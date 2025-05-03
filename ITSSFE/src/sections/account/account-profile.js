import {
  Avatar,
  Box,
  Button,
  Card,
  CardActions,
  CardContent,
  Divider,
  Typography,
} from "@mui/material";

export const AccountProfile = (props) => {
  const { user, ...other } = props;
  return (
    <Card>
      <CardContent>
        <Box
          sx={{
            alignItems: "center",
            display: "flex",
            flexDirection: "column",
          }}
        >
          <Avatar
            src={`/assets/avatars/${user.avatar}`} //{user.avatar}
            sx={{
              height: 80,
              mb: 2,
              width: 80,
            }}
          />
          <Typography gutterBottom variant="h5">
            {user.first_name} {user.last_name}
          </Typography>
          <Typography color="text.secondary" variant="body2">
            {user.gmail}
          </Typography>
          <Typography color="text.secondary" variant="body2">
            {user.role_name === "MANAGER"
              ? "Quản lý"
              : user.role_name === "TRAINER"
              ? "Huấn luyện viên"
              : user.role_name === "SALE"
              ? "Sale"
              : user.role_name === "CUSTOMER_CARE"
              ? "Chăm sóc khách hàng"
              : ""}
          </Typography>
        </Box>
      </CardContent>
      <Divider />
      {/* <CardActions>
        <Button fullWidth variant="text">
          Upload picture
        </Button>
      </CardActions> */}
    </Card>
  );
};
