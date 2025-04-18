import * as Yup from "yup";
import { useFormik } from "formik";
import {
  Box,
  IconButton,
  Button,
  Card,
  CardContent,
  CardHeader,
  Checkbox,
  FormHelperText,
  Link,
  Stack,
  TextField,
  Typography,
  MenuItem,
} from "@mui/material";
import { Layout as AuthLayout } from "src/layouts/auth/layout";
import { useAuth } from "src/hooks/use-auth";
import { useRouter } from "next/navigation";
import { toast } from "react-hot-toast";

const AVATAR = Array.from({ length: 24 }, (_, index) => `avatar_${index + 1}.jpg`);

const initialValues = {
  gmail: "",
  firstName: "",
  lastName: "",
  password: "",
  confirmPass: "",
  phone: "",
  isDeleted: false,
  policy: false,
  birth: new Date().toISOString().slice(0, 10),
  gender: "",
  avatar: "",
};

// Validate credentials
const validationSchema = Yup.object({
  gmail: Yup.string().email("Must be a valid email").max(255).required("Email is required"),
  password: Yup.string().min(7).max(255).required("Password is required"),
  confirmPass: Yup.string()
    .oneOf([Yup.ref("password"), null], "Passwords must match")
    .required("Confirm password is required"),
  policy: Yup.boolean().oneOf([true], "This field must be checked"),
});

const Page = () => {
  const router = useRouter();
  const auth = useAuth();
  // Routing
  const formik = useFormik({
    initialValues,
    validationSchema,
    onSubmit: async (values, helpers) => {
      try {
        console.log("values", values);
        await auth.signUp(values); //await auth.signUp(values.email, values.password);
        toast.success("Sign up successful");
        router.push("/auth/login");
      } catch (err) {
        helpers.setStatus({ success: false });
        helpers.setErrors({ submit: err.message });
        helpers.setSubmitting(false);
      }
    },
  });

  return (
    <Card elevation={16}>
      {/*Form's header*/}
      <CardHeader
        subheader={
          <Typography color="text.secondary" variant="body2">
            Already have an account?
            <Link href="/auth/login" underline="hover" variant="subtitle2">
              {" "}
              Log in
            </Link>
          </Typography>
        }
        sx={{ pb: 0 }}
        title="Register"
      />

      {/*Form's content*/}
      <CardContent>
        <form noValidate onSubmit={formik.handleSubmit}>
          <Stack spacing={3}>
            <TextField
              error={!!(formik.touched.gmail && formik.errors.gmail)}
              fullWidth
              helperText={formik.touched.gmail && formik.errors.gmail}
              label="Email Address"
              name="gmail"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              type="gmail"
              value={formik.values.gmail}
            />
            <TextField
              error={!!(formik.touched.firstName && formik.errors.firstName)}
              fullWidth
              helperText={formik.touched.firstName && formik.errors.firstName}
              label="First Name"
              name="firstName"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              value={formik.values.firstName}
            />
            <TextField
              error={!!(formik.touched.lastName && formik.errors.lastName)}
              fullWidth
              helperText={formik.touched.lastName && formik.errors.lastName}
              label="Last Name"
              name="lastName"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              value={formik.values.lastName}
            />

            <TextField
              error={!!(formik.touched.birth && formik.errors.birth)}
              fullWidth
              helperText={formik.touched.birth && formik.errors.birth}
              label="Birth"
              name="birth"
              type="date"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              value={formik.values.birth}
            />

            <TextField
              select
              error={!!(formik.touched.gender && formik.errors.gender)}
              fullWidth
              helperText={formik.touched.gender && formik.errors.gender}
              label="Gender"
              name="gender"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              value={formik.values.gender}
            >
              <MenuItem key={"male"} value={"male"}>
                Male
              </MenuItem>
              <MenuItem key={"female"} value={"female"}>
                Female
              </MenuItem>
            </TextField>

            <TextField
              error={!!(formik.touched.phone && formik.errors.phone)}
              fullWidth
              helperText={formik.touched.phone && formik.errors.phone}
              label="Phone"
              name="phone"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              value={formik.values.phone}
            />

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

            <TextField
              error={!!(formik.touched.password && formik.errors.password)}
              fullWidth
              helperText={formik.touched.password && formik.errors.password}
              label="Password"
              name="password"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              //type="password"
              value={formik.values.password}
            />
            <TextField
              error={!!(formik.touched.confirmPass && formik.errors.confirmPass)}
              fullWidth
              helperText={formik.touched.confirmPass && formik.errors.confirmPass}
              label="Confirm Password"
              name="confirmPass"
              onBlur={formik.handleBlur}
              onChange={formik.handleChange}
              value={formik.values.confirmPass}
            />
          </Stack>
          <Box
            sx={{
              alignItems: "center",
              display: "flex",
              ml: -1,
              mt: 1,
            }}
          >
            <Checkbox checked={formik.values.policy} name="policy" onChange={formik.handleChange} />
            <Typography color="text.secondary" variant="body2">
              I have read the{" "}
              <Link component="a" href="#">
                Terms and Conditions
              </Link>
            </Typography>
          </Box>
          {!!(formik.touched.policy && formik.errors.policy) && (
            <FormHelperText error>{formik.errors.policy}</FormHelperText>
          )}
          <Button fullWidth size="large" sx={{ mt: 2 }} type="submit" variant="contained">
            Register
          </Button>
        </form>
      </CardContent>
    </Card>
  );
};

Page.getLayout = (page) => <AuthLayout>{page}</AuthLayout>;

export default Page;
