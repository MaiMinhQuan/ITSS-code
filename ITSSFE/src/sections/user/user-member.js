const { parseISO, add } = require("date-fns");
import { Card, CardHeader, Divider, useMediaQuery } from "@mui/material";
import { PropertyList } from "src/components/property-list";
import { PropertyListItem } from "src/components/property-list-item";

export const UserMember = ({ register }) => {
  //console.log("register in UserMember", register);
  const mdUp = useMediaQuery((theme) => theme.breakpoints.up("md"));
  const align = mdUp ? "horizontal" : "vertical";

  const date = parseISO(register.created_at);
  const newDate = add(date, { days: 30 * register.time });

  const expirationDate = newDate.toISOString().slice(0, 10);

  return (
    <Card>
      <CardHeader title="Hồ sơ tập luyện" />
      <PropertyList>
        {(register && (
          <>
            <PropertyListItem
              align={align}
              divider
              label="Thẻ thành viên"
              value={register.id.toString()}
            />
            <PropertyListItem
              align={align}
              divider
              label="Gói tập"
              value={register.my_package_name}
            />
            <PropertyListItem
              align={align}
              divider
              label="Ngày đăng ký"
              value={register.created_at.slice(0, 10)}
            />
            <PropertyListItem align={align} divider label="Ngày hết hạn" value={expirationDate} />
            <PropertyListItem
              align={align}
              divider
              label="Huấn luyện viên"
              value={register.trainer_name}
            />
            <PropertyListItem
              align={align}
              divider
              label="Đăng ký bởi"
              value={register.register_by_name}
            />
          </>
        )) || (
          <>
            <PropertyListItem align={align} divider label="Thẻ thành viên" value="" />
            <PropertyListItem align={align} divider label="Gói tập" value="" />
            <PropertyListItem align={align} divider label="Ngày đăng ký" value="" />
            <PropertyListItem align={align} divider label="Ngày hết hạn" value="" />
            <PropertyListItem align={align} divider label="Huấn luyện viên" value="" />
            <PropertyListItem align={align} divider label="Đăng ký bởi" value="" />
          </>
        )}
      </PropertyList>
      <Divider />
    </Card>
  );
};
