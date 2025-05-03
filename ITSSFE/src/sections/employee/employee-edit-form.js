import NextLink from "next/link";
import PropTypes from "prop-types";
import toast from "react-hot-toast";
import * as Yup from "yup";
import { useRouter } from "next/navigation";
import { useFormik } from "formik";
import {
  Button,
  Card,
  CardContent,
  CardHeader,
  MenuItem,
  Stack,
  Switch,
  TextField,
  Typography,
  Unstable_Grid2 as Grid,
} from "@mui/material";
import { paths } from "src/paths";
import { wait } from "src/utils/wait";
import staffApi from "src/api/staff";
import { createResourceId } from "src/utils/create-resource-id";
import { id } from "date-fns/locale";

const ROLE = [
  {
    label: "Manager",
    value: 1,
  },
  {
    label: "Customer Care",
    value: 5,
  },
  {
    label: "Trainer",
    value: 3,
  },
  {
    label: "Sale",
    value: 4,
  },
];

const AVATAR = Array.from({ length: 24 }, (_, index) => `avatar_${index + 1}.jpg`);

const initialValues = (staff) => {
  const today = new Date().toISOString().slice(0, 10);
  if (staff) {
    staff.birth = staff.birth.slice(0, 10);
    return {
      last_name: staff.last_name || "",
      first_name: staff.first_name || "",
      gender: staff.gender || "male",
      birth: staff.birth || today,
      gmail: staff.gmail || "",
      phone: staff.phone || "",
      role_id: staff.role_id || 1,
      role_name: staff.role_name || "",
      submit: null,
      avatar: staff.avatar || "avatar_default.jpg",
      is_deleted: false,
      password: staff.password,
      id: staff.id,
    };
  }

  return {
    gmail: "",
    first_name: "",
    last_name: "",
    password: "",
    phone: "",
    is_deleted: false,
    birth: new Date().toISOString().slice(0, 10),
    gender: "",
    role_name: "",
    role_id: 5,
    avatar: "avatar_default.jpg",
  };
};

export const EmployeeEditForm = (props) => {
  const { staff, onClose, ...other } = props;
  //console.log("staff", staff);
  const router = useRouter();
  const formik = useFormik({
    initialValues: initialValues(staff),
    validationSchema: Yup.object({
      gender: Yup.string(),
      birth: Yup.string(),
      gmail: Yup.string().email("Email phải hợp lệ").max(255).required("Yêu cầu nhập email"),
      first_name: Yup.string().max(255).required("Yêu cầu nhập tên"),
      last_name: Yup.string().max(255),
      phone: Yup.string().max(15),
    }),
    onSubmit: async (values, helpers) => {
      try {
        if (values.role_id === 1) {
          values.role_name = "MANAGER";
        } else if (values.role_id === 3) {
          values.role_name = "TRAINER";
        } else if (values.role_id === 4) {
          values.role_name = "SALE";
        } else if (values.role_id === 5) {
          values.role_name = "CUSTOMER_CARE";
        }
        console.log("values", values);
        await staffApi.updateStaffById(values);
        await wait(500);
        helpers.setStatus({ success: true });
        helpers.setSubmitting(false);
        toast.success("Cập nhật thành công");
        console.log("update successfully");
        router.push(paths.staff.details(staff.id));
      } catch (err) {
        console.error(err);
        toast.error("Lỗi!");
        helpers.setStatus({ success: false });
        helpers.setErrors({ submit: err.message });
        helpers.setSubmitting(false);
      }
    },
  });

  return (
    <form onSubmit={formik.handleSubmit} {...other}>
      <Card>
        {/* CardHeader */}
        <CardHeader title="Cập nhật thông tin nhân viên" />

        {/* CardContent */}
        <CardContent sx={{ pt: 0 }}>
          <Grid container spacing={3}>
            {/* //first name */}
            <Grid xs={12} md={6}>
              <TextField
                error={!!(formik.touched.first_name && formik.errors.first_name)}
                fullWidth
                helperText={formik.touched.first_name && formik.errors.first_name}
                label="Họ"
                name="first_name"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.first_name}
              />
            </Grid>
            {/* //last name */}
            <Grid xs={12} md={6}>
              <TextField
                error={!!(formik.touched.last_name && formik.errors.last_name)}
                fullWidth
                helperText={formik.touched.last_name && formik.errors.last_name}
                label="Tên"
                name="last_name"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.last_name}
              />
            </Grid>
            {/* //email */}
            <Grid xs={12} md={6}>
              <TextField
                error={!!(formik.touched.gmail && formik.errors.gmail)}
                fullWidth
                helperText={formik.touched.gmail && formik.errors.gmail}
                label="Email"
                name="gmail"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                required
                value={formik.values.gmail}
              />
            </Grid>
            {/* //Password */}
            <Grid xs={12} md={6}>
              <TextField
                error={!!(formik.touched.password && formik.errors.password)}
                fullWidth
                helperText={formik.touched.password && formik.errors.password}
                label="Mật khẩu"
                name="password"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.password}
              />
            </Grid>
            {/* //Phone number */}
            <Grid xs={12} md={6}>
              <TextField
                error={!!(formik.touched.phone && formik.errors.phone)}
                fullWidth
                helperText={formik.touched.phone && formik.errors.phone}
                label="Số điện thoại"
                name="phone"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.phone}
              />
            </Grid>
            {/* //Gender */}
            <Grid xs={12} md={6}>
              <TextField
                select
                error={!!(formik.touched.gender && formik.errors.gender)}
                fullWidth
                helperText={formik.touched.gender && formik.errors.gender}
                label="Giới tính"
                name="gender"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.gender}
              >
                <MenuItem key={"male"} value={"male"}>
                  Nam
                </MenuItem>
                <MenuItem key={"female"} value={"female"}>
                  Nữ
                </MenuItem>
              </TextField>
            </Grid>
            {/* //birthday */}
            <Grid xs={12} md={6}>
              <TextField
                error={!!(formik.touched.birth && formik.errors.birth)}
                fullWidth
                helperText={formik.touched.birth && formik.errors.birth}
                label="Sinh nhật"
                name="birth"
                type="date"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.birth}
              />
            </Grid>
            {/* //Role */}
            <Grid xs={12} md={6}>
              <TextField
                select
                error={!!(formik.touched.role_id && formik.errors.role_id)}
                fullWidth
                helperText={formik.touched.role_id && formik.errors.role_id}
                label="Vai trò"
                name="role_id"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.role_id}
              >
                {ROLE.map((option) => (
                  <MenuItem key={option.label} value={option.value}>
                    {option.label}
                  </MenuItem>
                ))}
              </TextField>
            </Grid>
            {/* //Avatar */}
            <Grid xs={12} md={6}>
              <TextField
                select
                error={!!(formik.touched.avatar && formik.errors.avatar)}
                fullWidth
                helperText={formik.touched.avatar && formik.errors.avatar}
                label="Avatar"
                name="avatar"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.avatar}
              >
                {AVATAR.map((option) => (
                  <MenuItem key={option} value={option}>
                    {option}
                  </MenuItem>
                ))}
              </TextField>
            </Grid>
          </Grid>
        </CardContent>

        {/* //Buttons */}
        <Stack
          direction={{
            xs: "column",
            sm: "row",
          }}
          flexWrap="wrap"
          spacing={3}
          sx={{ p: 3 }}
        >
          <Button disabled={formik.isSubmitting} type="submit" variant="contained">
            Lưu
          </Button>
          {staff ? (
            <Button
              color="inherit"
              component={NextLink}
              disabled={formik.isSubmitting}
              href={paths.staff.details(staff.id)}
            >
              Hủy
            </Button>
          ) : (
            <Button color="inherit" disabled={formik.isSubmitting} onClick={onClose}>
              Cancel
            </Button>
          )}
        </Stack>
      </Card>
    </form>
  );
};

EmployeeEditForm.propTypes = {
  staff: PropTypes.object,
  onClose: PropTypes.func,
};
