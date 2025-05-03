import PropTypes from "prop-types";
import { parseISO, format } from "date-fns";
import numeral from "numeral";
import {
  Box,
  Table,
  TableBody,
  TableCell,
  TablePagination,
  TableRow,
  Typography,
} from "@mui/material";

const convertMonthToVietnamese = (month) => {
  if (month === "Jan") return "Tháng 1";
  else if (month === "Feb") return "Tháng 2";
  else if (month === "Mar") return "Tháng 3";
  else if (month === "Apr") return "Tháng 4";
  else if (month === "May") return "Tháng 5";
  else if (month === "Jun") return "Tháng 6";
  else if (month === "Jul") return "Tháng 7";
  else if (month === "Aug") return "Tháng 8";
  else if (month === "Sep") return "Tháng 9";
  else if (month === "Oct") return "Tháng 10";
  else if (month === "Nov") return "Tháng 11";
  else if (month === "Dec") return "Tháng 12";
  return month; // Trả về giá trị gốc nếu không khớp
};

export const RegisListTable = (props) => {
  const {
    onRegisSelect,
    onPageChange,
    onRowsPerPageChange,
    regiss,
    regissCount,
    page,
    rowsPerPage,
    ...other
  } = props;

  return (
    <div {...other}>
      <Table>
        <TableBody>
          {regiss.map((regis) => {
            const createdAt = parseISO(regis.created_at);

            // Lấy tháng và chuyển sang tiếng Việt
            const createdAtMonth = convertMonthToVietnamese(format(createdAt, "LLL"));
            const createdAtDay = format(createdAt, "d");

            //const totalAmount = numeral(regis.price).format(`0,0.00 đ`);
            const totalAmount = new Intl.NumberFormat("vi-VN", {
              style: "currency",
              currency: "VND",
            }).format(regis.price);
            return (
              <TableRow
                hover
                key={regis.id}
                onClick={() => {
                  onRegisSelect?.(regis.id);
                }}
                sx={{ cursor: "pointer" }}
              >
                <TableCell
                  sx={{
                    alignItems: "center",
                    display: "flex",
                  }}
                >
                  <Box
                    sx={{
                      backgroundColor: (theme) =>
                        theme.palette.mode === "dark" ? "neutral.800" : "neutral.200",
                      borderRadius: 2,
                      maxWidth: "fit-content",
                      ml: 3,
                      p: 1,
                    }}
                  >
                    <Typography align="center" variant="subtitle2">
                      {createdAtMonth}
                    </Typography>
                    <Typography align="center" variant="h6">
                      {createdAtDay}
                    </Typography>
                  </Box>
                  <Box sx={{ ml: 2 }}>
                    <Typography variant="subtitle2">{regis.customer_name}</Typography>
                    <Typography color="text.secondary" variant="body2">
                      {regis.my_package_name}
                    </Typography>
                  </Box>
                </TableCell>
                <TableCell align="right">{totalAmount}</TableCell>
              </TableRow>
            );
          })}
        </TableBody>
      </Table>
      <TablePagination
        component="div"
        count={regissCount}
        onPageChange={onPageChange}
        onRowsPerPageChange={onRowsPerPageChange}
        page={page}
        rowsPerPage={rowsPerPage}
        rowsPerPageOptions={[5, 10, 25]}
      />
    </div>
  );
};

RegisListTable.propTypes = {
  onRegisSelect: PropTypes.func,
  onPageChange: PropTypes.func.isRequired,
  onRowsPerPageChange: PropTypes.func,
  regiss: PropTypes.array.isRequired,
  regissCount: PropTypes.number,
  page: PropTypes.number.isRequired,
  rowsPerPage: PropTypes.number.isRequired,
};
