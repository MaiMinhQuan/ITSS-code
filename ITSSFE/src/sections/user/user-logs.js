import PropTypes from "prop-types";
import { useState } from "react";
import { parseISO, format } from "date-fns";
import {
  Card,
  CardHeader,
  CardContent,
  Table,
  TableBody,
  TableCell,
  TextField,
  Stack,
  Button,
  TableHead,
  TablePagination,
  TableRow,
  Dialog,
  IconButton,
  Typography,
  Grid,
} from "@mui/material";
import { MoreMenu } from "src/components/more-menu";
import { Scrollbar } from "src/components/scrollbar";
import AddIcon from "@mui/icons-material/Add";
// import { useAuth } from "src/hooks/use-auth";
import { createResourceId } from "src/utils/create-resource-id";
import { useAuth } from "src/hooks/use-auth";
import { useFormik } from "formik";

export const UserLogs = (props) => {
  const { register, logs, addLog, getLogs, registerId, ...other } = props;
  // console.log("register in user logs", register);
  const [openModal, setOpenModal] = useState(false);
  // const role = useAuth().user.role;
  const role = useAuth().user.role_name;
  // console.log("useAuth", useAuth());
  // console.log("role in user logs", role);

  const trainer = register ? register.trainer_name : "";
  const activityLogs = logs.map((log) => ({ ...log, trainer_name: trainer }));
  // console.log("activityLogs", activityLogs);
  // console.log("register in user logs", register);

  const onCloseModel = () => {
    setOpenModal(false);
  };

  const onClickAdd = (activityLogs) => {
    // console.log("activityLogs in onClickAdd", activityLogs);
    const newLog = {
      //id: createResourceId(),
      //created_at: new Date().toISOString(),
      content: document.getElementById("activity").value,
      created_at: document.getElementById("date").value,
      register_id: registerId,
    };
    console.log("newLog", newLog);
    addLog(newLog);
    getLogs();
    setOpenModal(false);
  };
  return (
    <Card {...other}>
      <CardHeader
        action={
          <Grid container spacing={2}>
            {/* {role === "MANAGER" ||
              (role === "TRAINER" && (
                <IconButton
                  aria-label="add"
                  color="primary"
                  onClick={() => {
                    setOpenModal(true);
                  }}
                >
                  <AddIcon />
                </IconButton>
              ))} */}
            {(role === "MANAGER" || role === "TRAINER") && (
              <IconButton
                aria-label="add"
                color="primary"
                onClick={() => {
                  setOpenModal(true);
                }}
              >
                <AddIcon />
              </IconButton>
            )}
            <MoreMenu />
          </Grid>
        }
        title="Hoạt động gần đây"
      />
      <Scrollbar>
        <Table sx={{ minWidth: 700 }}>
          <TableHead>
            <TableRow>
              <TableCell>Huấn luyện viên</TableCell>
              <TableCell>Nội dung</TableCell>
              <TableCell>Ngày</TableCell>
            </TableRow>
          </TableHead>
          {activityLogs && (
            <TableBody>
              {activityLogs.map((log) => {
                return (
                  <TableRow key={log.id}>
                    <TableCell>
                      <Typography>{log.trainer_name}</Typography>
                    </TableCell>
                    <TableCell>
                      <Typography>{log.content}</Typography>
                    </TableCell>
                    <TableCell>{log.created_at.slice(0, 10)}</TableCell>
                  </TableRow>
                );
              })}
            </TableBody>
          )}
        </Table>
      </Scrollbar>
      <Dialog open={openModal} onClose={onCloseModel}>
        <Card sx={{ width: "400px" }}>
          <CardHeader title="Thêm hoạt động" />
          <CardContent sx={{ pt: "0px" }}>
            <TextField label="Hoạt động" name="activity" id="activity" />
          </CardContent>
          <CardContent sx={{ pt: "0px", justifyContent: "flex-end " }}>
            <TextField label="Ngày" name="date" id="date" type="date" />
          </CardContent>
          {/* <TextField
            error={!!(formik.touched.birth && formik.errors.birth)}
            fullWidth
            helperText={formik.touched.birth && formik.errors.birth}
            label="Birthday"
            name="birth"
            type="date"
            onBlur={formik.handleBlur}
            onChange={formik.handleChange}
            value={formik.values.birth}
          /> */}
          <Stack
            direction={{
              xs: "column",
              sm: "row",
            }}
            flexWrap="wrap"
            spacing={3}
            sx={{ p: 3 }}
          >
            <Button variant="contained" onClick={() => onClickAdd(activityLogs)}>
              Thêm
            </Button>
            <Button color="inherit" onClick={onCloseModel}>
              Hủy
            </Button>
          </Stack>
        </Card>
      </Dialog>
    </Card>
  );
};

UserLogs.propTypes = {
  logs: PropTypes.array,
  logs: PropTypes.array,
};
