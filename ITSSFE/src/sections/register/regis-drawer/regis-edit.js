import PropTypes from "prop-types";
import { useCallback, useState, useEffect } from "react";
import { Button, Stack, TextField, Typography, Autocomplete, Box } from "@mui/material";
import { useFormik } from "formik";
import * as Yup from "yup";
import { useMounted } from "src/hooks/use-mounted";
import employeesApi from "src/api/staff";
import packagesApi from "src/api/packages";
import { toast } from "react-hot-toast";
import { createResourceId } from "src/utils/create-resource-id";
import staffApi from "src/api/staff";
import customersApi from "src/api/customers/index.js";

const useCoach = (coachId) => {
  const isMounted = useMounted();
  const [state, setState] = useState({
    coachSelect: [],
    coach: null,
  });

  const getEmployees = useCallback(async () => {
    try {
      // const response = await staffApi.getStaff({
      //   filters: {
      //     query: undefined,
      //     role: "TRAINER",
      //   },
      //   page: 0,
      //   rowsPerPage: 5,
      //   sortBy: "updatedAt",
      //   sortDir: "desc",
      // });
      const response = await staffApi.getTrainer();
      //console.log(coachId);
      //console.log("getTrainer: ", response);

      if (isMounted()) {
        const coachSelect = response;
        //console.log(coachSelect);
        const filteredCoach = coachSelect.find((item) => item.id === coachId);
        //console.log(filteredCoach);
        const result = { coachSelect: coachSelect, coach: filteredCoach };
        setState(result);
      }
    } catch (err) {
      console.error(err);
    }
  }, []);

  useEffect(() => {
    getEmployees();
  }, []);

  return state;
};

const useCustomer = (customerId) => {
  const isMounted = useMounted();
  const [state, setState] = useState({
    customerSelect: [],
    customer: null,
  });

  const getEmployees = useCallback(async () => {
    try {
      const response = await customersApi.getCustomers();
      console.log("getCustomer: ", response);

      if (isMounted()) {
        const customerSelect = response.data;
        //console.log(coachSelect);
        const filteredCustomer = customerSelect.find((item) => item.id === customerId);
        //console.log(filteredCoach);
        const result = { customerSelect: customerSelect, customer: filteredCustomer };
        setState(result);
      }
    } catch (err) {
      console.error(err);
    }
  }, []);

  useEffect(() => {
    getEmployees();
  }, []);

  return state;
};

const usePackages = (packId) => {
  const isMounted = useMounted();
  const [state, setState] = useState({
    packSelect: [],
    pack: null,
  });

  const getPackages = useCallback(async () => {
    try {
      const response = await packagesApi.getPackages();
      //console.log("getPackage: ", response.data);
      if (isMounted()) {
        const packSelect = response.data;
        //console.log(packSelect);
        const filteredPack = packSelect.find((item) => item.id === packId);
        //console.log(filteredPack);
        const result = { packSelect: packSelect, pack: filteredPack };
        setState(result);
      }
    } catch (err) {
      console.error(err);
    }
  }, []);

  useEffect(() => {
    getPackages();
  }, []);

  return state;
};

export const RegisEdit = (props) => {
  const { onCancel, regis, setIsEditing, createRegis, updateRegis } = props;
  console.log("regis in regis-edit: ", regis);
  const { coachSelect, coach } = useCoach(regis.trainer_id);
  //console.log("coach in regis-edit: ", coach);
  const { customerSelect, customer } = useCustomer(regis.customer_id);
  //console.log("customer in regis-edit: ", customer);
  const { packSelect, pack } = usePackages(regis.my_package_id);
  //console.log("pack in regis-edit: ", packSelect);

  // const handleCloseFormEdit = () => {
  //   setIsEditing(false);
  // };

  const formik = useFormik({
    initialValues: {
      customer: customer,
      trainer: coach,
      pack: pack,
    },
    // validationSchema: validationSchema,
    onSubmit: async (values, helpers) => {
      try {
        console.log("values in regis-edit: ", values);
        if (regis.id !== null) {
          const updateRegister = {
            ...regis,
            customer_id: values.customer ? values.customer.id : null,
            customer_name: values.customer
              ? `${values.customer.first_name} ${values.customer.last_name}`
              : null,
            trainer_id: values.trainer ? values.trainer.id : null,
            trainer_name: values.trainer
              ? `${values.trainer.first_name} ${values.trainer.last_name}`
              : null,
            my_package_id: values.pack.id,
            my_package_name: values.pack.name,
            price: values.pack.price,
          };
          console.log("updateRegister in regis-edit: ", updateRegister);
          updateRegis(updateRegister, regis.id);
          await wait(500);
          helpers.setStatus({ success: true });
          helpers.setSubmitting(false);
          toast.success("Thành công");
        } else {
          const newRegis = {
            ...regis,
            customer_id: values.customer ? values.customer.id : null,
            customer_name: values.customer
              ? `${values.customer.first_name} ${values.customer.last_name}`
              : null,
            gmail: values.customer ? values.customer.gmail : null,
            trainer_id: values.trainer ? values.trainer.id : null,
            trainer_name: values.trainer
              ? `${values.trainer.first_name} ${values.trainer.last_name}`
              : null,
            my_package_id: values.pack.id,
            my_package_name: values.pack.name,
            price: values.pack.price,
            is_registered: null,
            is_deleted: false,
          };
          console.log("newRegis in regis-edit: ", newRegis);
          createRegis(newRegis);
          await wait(500);
          helpers.setStatus({ success: true });
          helpers.setSubmitting(false);
          toast.success("Thành công");
        }
      } catch (err) {
        console.error(err);
        //toast.error("Lỗi!");
        toast.success("Successfully");
        helpers.setStatus({ success: false });
        helpers.setErrors({ submit: err.message });
        helpers.setSubmitting(false);
      }
      setIsEditing(false);
    },
  });

  useEffect(() => {
    if (customer) {
      formik.setFieldValue("customer", customer); // Đồng bộ giá trị mặc định
    }
  }, [customer]);

  useEffect(() => {
    if (coach) {
      formik.setFieldValue("trainer", coach); // Đồng bộ giá trị mặc định
    }
  }, [coach]);

  useEffect(() => {
    if (pack) {
      formik.setFieldValue("pack", pack); // Đồng bộ giá trị mặc định
    }
  }, [pack]);

  const onChangePackage = (value) => {
    if (value) document.getElementById("totalAmountField").value = value.price;
    return;
  };

  return (
    <form onSubmit={formik.handleSubmit}>
      <Stack spacing={3}>
        <Typography variant="h6">{regis.id ? "Cập nhật" : "Đăng ký"}</Typography>
        <Stack spacing={3}>
          <TextField
            disabled
            fullWidth
            label="Tạo bởi"
            name="register_by_name"
            value={regis.register_by_name}
          />
          <TextField
            disabled
            fullWidth
            label="Ngày"
            name="date"
            value={regis.created_at.slice(0, 10)}
          />
          {/* <TextField
            fullWidth
            label="Customer name"
            name="customer_name"
            value={formik.values.customer_name}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.customer?.name && formik.errors.customer?.name}
            helperText={formik.touched.customer?.name && formik.errors.customer?.name}
          /> */}
          {/* <TextField
            fullWidth
            label="Email"
            name="gmail"
            value={formik.values.gmail}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
            error={formik.touched.customer?.email && formik.errors.customer?.email}
            helperText={formik.touched.customer?.email && formik.errors.customer?.email}
          /> */}
          <Autocomplete
            id="customerSelect"
            fullWidth
            options={customerSelect}
            value={formik.values.customer}
            autoHighlight
            //defaultValue={customer}
            onChange={(event, value) => formik.setFieldValue("customer", value)}
            getOptionLabel={(option) => `${option.first_name} ${option.last_name}`}
            renderOption={(props, option) => (
              <Box
                component="li"
                //sx={{ "& > img": { mr: 2, flexShrink: 0 }, borderRadius: "50%" }}
                {...props}
              >
                <img loading="lazy" width="40" src={`/assets/avatars/${option.avatar}`} alt="" />
                {`${option.first_name} ${option.last_name} - ${option.gmail}`}
              </Box>
            )}
            renderInput={(params) => <TextField {...params} label="Khách hàng" />}
          />
          <Autocomplete
            id="coachSelect"
            fullWidth
            options={coachSelect}
            value={formik.values.trainer}
            autoHighlight
            //defaultValue={coach}
            onChange={(event, value) => formik.setFieldValue("trainer", value)}
            getOptionLabel={(option) => `${option.first_name} ${option.last_name}`}
            renderOption={(props, option) => (
              <Box
                component="li"
                //sx={{ "& > img": { mr: 2, flexShrink: 0 }, borderRadius: "50%" }}
                {...props}
              >
                <img loading="lazy" width="40" src={`/assets/avatars/${option.avatar}`} alt="" />
                {`${option.first_name} ${option.last_name} - ${option.gmail}`}
              </Box>
            )}
            renderInput={(params) => <TextField {...params} label="Huấn luyện viên" />}
          />
          <Autocomplete
            id="packSelect"
            fullWidth
            options={packSelect}
            value={formik.values.pack}
            autoHighlight
            //defaultValue={pack}
            getOptionLabel={(option) => option.name}
            onChange={(event, value) => {
              formik.setFieldValue("pack", value);
              onChangePackage(value);
            }}
            renderOption={(props, option) => (
              <Box
                component="li"
                //sx={{ "& > img": { mr: 2, flexShrink: 0 }, borderRadius: "50%" }}
                {...props}
              >
                {option.name}
              </Box>
            )}
            renderInput={(params) => <TextField {...params} label="Gói" />}
          />
          <TextField
            id="totalAmountField"
            fullWidth
            autoHighlight
            label="Giá tiền"
            name="totalAmount"
            InputProps={{
              readOnly: true,
            }}
            defaultValue={regis.price}
          />
        </Stack>
        <Stack alignItems="center" direction="row" flexWrap="wrap" spacing={2}>
          <Button color="primary" type="submit" size="small" variant="contained">
            Lưu
          </Button>
          <Button color="inherit" onClick={onCancel} size="small">
            Hủy
          </Button>
        </Stack>
      </Stack>
    </form>
  );
};

RegisEdit.propTypes = {
  onCancel: PropTypes.func,
  onSave: PropTypes.func,
  regis: PropTypes.object,
  regis: PropTypes.object,
};
