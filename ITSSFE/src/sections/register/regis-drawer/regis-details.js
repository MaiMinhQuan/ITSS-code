import PropTypes from "prop-types";
import { parseISO, format } from "date-fns";
import numeral from "numeral";
import Edit02Icon from "@untitled-ui/icons-react/build/esm/Edit02";
import { Button, Stack, SvgIcon, Typography, useMediaQuery } from "@mui/material";
import { PropertyList } from "src/components/property-list";
import { PropertyListItem } from "src/components/property-list-item";

export const RegisDetails = (props) => {
  const { onApprove, onEdit, onReject, regis } = props;
  const lgUp = useMediaQuery((theme) => theme.breakpoints.up("lg"));

  const align = lgUp ? "horizontal" : "vertical";

  const createdDate = parseISO(regis.created_at);
  const currentDate = new Date();
  createdDate.setDate(createdDate.getDate() + 7);
  //const editable = createdDate >= currentDate;
  const editable = true;

  const totalAmount = numeral(regis.price).format(`0,0.00 $`);

  return (
    <Stack spacing={6}>
      <Stack spacing={3}>
        <Stack alignItems="center" direction="row" justifyContent="space-between" spacing={3}>
          <Typography variant="h6">Chi tiết</Typography>
          {editable && (
            <Button
              color="inherit"
              onClick={onEdit}
              size="small"
              startIcon={
                <SvgIcon>
                  <Edit02Icon />
                </SvgIcon>
              }
            >
              Cập nhật
            </Button>
          )}
        </Stack>
        <PropertyList>
          <PropertyListItem
            align={align}
            disableGutters
            divider
            label="Tạo bởi"
            value={regis.register_by_name}
          />
          <PropertyListItem align={align} disableGutters divider label="Khách hàng">
            <Typography color="text.secondary" variant="body2">
              {regis.customer_name}
            </Typography>
            <Typography color="text.secondary" variant="body2">
              {regis.gmail}
            </Typography>
          </PropertyListItem>
          <PropertyListItem
            align={align}
            disableGutters
            divider
            label="Ngày"
            value={regis.created_at.slice(0, 10)}
          />
          <PropertyListItem
            align={align}
            disableGutters
            divider
            label="Huấn luyện viên"
            value={regis.trainer_name}
          />
          <PropertyListItem
            align={align}
            disableGutters
            divider
            label="Gói tập"
            value={regis.my_package_name}
          />
          <PropertyListItem
            align={align}
            disableGutters
            divider
            label="Giá tiền"
            value={totalAmount}
          />
        </PropertyList>
      </Stack>
    </Stack>
  );
};

RegisDetails.propTypes = {
  onApprove: PropTypes.func,
  onEdit: PropTypes.func,
  onReject: PropTypes.func,
  regis: PropTypes.object,
};
