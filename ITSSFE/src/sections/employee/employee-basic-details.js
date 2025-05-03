import PropTypes from "prop-types";
import { Card, CardHeader, useMediaQuery } from "@mui/material";
import { PropertyList } from "src/components/property-list";
import { PropertyListItem } from "src/components/property-list-item";

export const EmployeeBasicDetails = (props) => {
  const { email, phone, gender, birthday, role, ...other } = props;
  const mdUp = useMediaQuery((theme) => theme.breakpoints.up("md"));
  const align = mdUp ? "horizontal" : "vertical";
  return (
    <Card {...other}>
      <CardHeader title="Staff Details" />
      <PropertyList>
        <PropertyListItem
          align={align}
          divider
          label="Giới tính"
          value={gender === "male" ? "Nam" : "Nữ"}
        />
        <PropertyListItem align={align} divider label="Sinh nhật" value={birthday.slice(0, 10)} />
        <PropertyListItem align={align} divider label="Email" value={email} />
        <PropertyListItem align={align} divider label="Số điện thoại" value={phone} />
        <PropertyListItem
          align={align}
          divider
          label="Vai trò"
          value={
            role === "MANAGER"
              ? "Quản lý"
              : role === "TRAINER"
              ? "Huấn luyện viên"
              : role === "SALE"
              ? "Sale"
              : role === "CUSTOMER_CARE"
              ? "Chăm sóc khách hàng"
              : ""
          }
        />
      </PropertyList>
    </Card>
  );
};

EmployeeBasicDetails.propTypes = {
  email: PropTypes.string.isRequired,
  // isVerified: PropTypes.bool.isRequired,
  phone: PropTypes.string,
  gender: PropTypes.string,
  birthday: PropTypes.string,
  role: PropTypes.string,
  gender: PropTypes.string,
};
