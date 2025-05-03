import { useCallback, useState } from "react";
import { useFormik } from "formik";
import toast from "react-hot-toast";
import * as Yup from "yup";
import {
  Box,
  Button,
  MenuItem,
  Card,
  CardActions,
  CardContent,
  CardHeader,
  Divider,
  TextField,
  Unstable_Grid2 as Grid,
} from "@mui/material";
import usersApi from "src/api/customers";
import { useRouter } from "next/navigation";
import { useAuth } from "src/hooks/use-auth";

const AVATAR = Array.from({ length: 24 }, (_, index) => `avatar_${index + 1}.jpg`);

const initialValues = (user) => {
  const today = new Date().toISOString().slice(0, 10);
  if (user) {
    user.birth = user.birth.slice(0, 10);
    return {
      last_name: user.last_name || "",
      first_name: user.first_name || "",
      gender: user.gender || "male",
      birth: user.birth || today,
      gmail: user.gmail || "",
      phone: user.phone || "",
      role_id: user.role_id || 1,
      role_name: user.role_name || "",
      submit: null,
      avatar: user.avatar || "avatar_default.jpg",
      is_deleted: false,
      password: user.password,
      id: user.id,
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
    role_id: 2,
    avatar: "avatar_default.jpg",
  };
};

export const AccountProfileDetails = (props) => {
  const { user, ...other } = props;
  const auth = useAuth();
  const router = useRouter();
  const formik = useFormik({
    initialValues: initialValues(user),
    validationSchema: Yup.object({
      first_name: Yup.string().max(255),
      gender: Yup.string(),
      birth: Yup.string(),
      gmail: Yup.string().email("Email phải hợp lệ").max(255).required("Yêu cầu nhập email"),
      last_name: Yup.string().max(255),
      phone: Yup.string().max(15),
    }),
    onSubmit: async (values, helpers) => {
      try {
        // const updateUser = {
        //   ...user,
        //   ...values,
        // };
        // console.log(updateUser);
        // usersApi.updateUserById(user.id, updateUser);
        // helpers.setStatus({ success: true });
        // helpers.setSubmitting(false);
        // toast.success("User updated");
        usersApi.updateCustomerById(values);
        helpers.setStatus({ success: true });
        helpers.setSubmitting(false);
        toast.success("Thành công");
        // router.push("/");

        auth.signOut();
        router.push("/auth/login");
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
    <form onSubmit={formik.handleSubmit}>
      <Card>
        {/* subheader="Thông tin có thể được cập nhật" */}
        <CardHeader title="Hồ sơ" />
        <CardContent sx={{ pt: 0 }}>
          <Box sx={{ m: -1.5 }}>
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
          </Box>
        </CardContent>
        <Divider />
        <CardActions sx={{ justifyContent: "flex-end" }}>
          <Button type="submit" variant="contained">
            Lưu
          </Button>
        </CardActions>
      </Card>
    </form>
  );
};
