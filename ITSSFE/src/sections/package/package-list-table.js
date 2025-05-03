import { Fragment, useCallback, useState, useEffect } from "react";
import numeral from "numeral";
import PropTypes from "prop-types";
import { toast } from "react-hot-toast";
import ChevronDownIcon from "@untitled-ui/icons-react/build/esm/ChevronDown";
import ChevronRightIcon from "@untitled-ui/icons-react/build/esm/ChevronRight";
import DotsHorizontalIcon from "@untitled-ui/icons-react/build/esm/DotsHorizontal";
import Image01Icon from "@untitled-ui/icons-react/build/esm/Image01";
import {
  Box,
  Button,
  CardContent,
  Divider,
  Grid,
  IconButton,
  InputAdornment,
  Stack,
  SvgIcon,
  Switch,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TablePagination,
  TableRow,
  TextField,
  Typography,
} from "@mui/material";
import { Scrollbar } from "src/components/scrollbar";

export const PackageListTable = (props) => {
  const {
    onPageChange,
    onRowsPerPageChange,
    page,
    packages,
    packagesCount,
    rowsPerPage,
    deletePackage,
    updatePackage,
    query1,
    ...other
  } = props;

  const [currentPackage, setCurrentPackage] = useState({
    id: "",
    name: "",
    price: "",
    description: "",
  });

  const [updatedPackage, setUpdatedPackage] = useState({
    name: "",
    price: "",
    description: "",
  });

  //console.log("packages in list table: ", packages);

  useEffect(() => {
    setUpdatedPackage({
      name: currentPackage.name,
      price: currentPackage.price,
      description: currentPackage.description,
    });
  }, [currentPackage]);

  const handleUpdatedPackage = (field, value) => {
    setUpdatedPackage((prevState) => ({
      ...prevState,
      [field]: value,
    }));
  };

  const handleName = (event) => {
    setUpdatedPackage((prevState) => ({
      ...prevState,
      name: event.target.value,
    }));
  };

  const handleTime = (event) => {
    setUpdatedPackage((prevState) => ({
      ...prevState,
      time: event.target.value,
    }));
  };

  const handlePrice = (event) => {
    setUpdatedPackage((prevState) => ({
      ...prevState,
      price: event.target.value,
    }));
  };

  const handleDes = (event) => {
    setUpdatedPackage((prevState) => ({
      ...prevState,
      description: event.target.value,
    }));
  };

  const handlePackageToggle = useCallback((pack) => {
    setCurrentPackage((prevPackage) => {
      if (prevPackage === pack) {
        return {
          id: "",
          name: "",
          price: "",
          description: "",
        };
      }
      return pack;
    });
  }, []);

  const handlePackageClose = useCallback(() => {
    setCurrentPackage({
      id: "",
      name: "",
      price: "",
      description: "",
    });
  }, []);

  const handlePackageUpdate = useCallback(
    (packageId) => {
      // packagesApi.updatePackageById(packageId, updatedPackage);
      console.log("updatedPackage", updatedPackage);
      updatePackage(packageId, updatedPackage);
      //console.log("Hello from package list table");
      setCurrentPackage({
        id: "",
        name: "",
        price: "",
        description: "",
      });
      toast.success("Thành công");
    },
    [updatedPackage]
  );

  const handlePackageDelete = useCallback((packageId) => {
    // packagesApi.deletePackageById(packageId);
    console.log("Hello from handlePackageDelete");
    deletePackage(packageId);
    setCurrentPackage({
      id: "",
      name: "",
      price: "",
      description: "",
    });
    toast.success("Thành công");
  }, []);

  const updatePackageQuery = useCallback(
    (packageList) => {
      //console.log("Query in updateUserQuery", query);
      const searchTerms = query1.toLowerCase().trim().split(/\s+/);

      // Lọc danh sách user
      const packageQuery = packageList.filter((package1) => {
        const packageName = `${package1.name}`.toLowerCase();
        return searchTerms.every((term) => packageName.includes(term));
      });

      return packageQuery;
    },
    [query1]
  );

  return (
    <div {...other}>
      <Scrollbar>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell />
              <TableCell>Tên gói tập</TableCell>
              <TableCell>Giá</TableCell>
              <TableCell>Thời gian</TableCell>
              <TableCell>Mô tả</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {updatePackageQuery(packages).map((pack) => {
              if (!pack._deleted) {
                //console.log(pack);
                const isCurrent = pack.id === currentPackage.id;
                const price = numeral(pack.price).format(`${pack.currency}0,0.00`);

                return (
                  <Fragment key={pack.id}>
                    <TableRow hover key={pack.id}>
                      <TableCell
                        padding="checkbox"
                        sx={{
                          ...(isCurrent && {
                            position: "relative",
                            "&:after": {
                              position: "absolute",
                              content: '" "',
                              top: 0,
                              left: 0,
                              backgroundColor: "primary.main",
                              width: 3,
                              height: "calc(100% + 1px)",
                            },
                          }),
                        }}
                        width="25%"
                      >
                        <IconButton onClick={() => handlePackageToggle(pack)}>
                          <SvgIcon>
                            {isCurrent ? <ChevronDownIcon /> : <ChevronRightIcon />}
                          </SvgIcon>
                        </IconButton>
                      </TableCell>
                      <TableCell>
                        <Box
                          sx={{
                            alignItems: "center",
                            display: "flex",
                          }}
                        >
                          <Box
                            sx={{
                              cursor: "pointer",
                              ml: 2,
                            }}
                          >
                            <Typography variant="subtitle2">{pack.name}</Typography>
                          </Box>
                        </Box>
                      </TableCell>
                      <TableCell>{price}</TableCell>
                      <TableCell>{`${pack.time} month`}</TableCell>
                      <TableCell width={"50%"}>{pack.description}</TableCell>
                    </TableRow>
                    {isCurrent && (
                      <TableRow>
                        <TableCell
                          colSpan={7}
                          sx={{
                            p: 0,
                            position: "relative",
                            "&:after": {
                              position: "absolute",
                              content: '" "',
                              top: 0,
                              left: 0,
                              backgroundColor: "primary.main",
                              width: 3,
                              height: "calc(100% + 1px)",
                            },
                          }}
                        >
                          <CardContent>
                            <Grid container spacing={3}>
                              <Grid item md={12} xs={12}>
                                <Typography variant="h6">Chi tiết</Typography>
                                <Divider sx={{ my: 2 }} />
                              </Grid>
                              <Grid item md={6} xs={12}>
                                <Stack container spacing={3}>
                                  <TextField
                                    defaultValue={pack.name}
                                    onChange={handleName}
                                    fullWidth
                                    label="Tên gói tập"
                                    name="name"
                                  />
                                  <Grid container>
                                    <Grid md={6} pr={0.5}>
                                      <TextField
                                        defaultValue={pack.price}
                                        onChange={handlePrice}
                                        fullWidth
                                        label="Giá"
                                        name="price"
                                        InputProps={{
                                          startAdornment: (
                                            <InputAdornment position="start">đ</InputAdornment>
                                          ),
                                        }}
                                        type="number"
                                      />
                                    </Grid>
                                    <Grid md={6} pl={0.5}>
                                      <TextField
                                        defaultValue={pack.time}
                                        onChange={handleTime}
                                        fullWidth
                                        label="Thời gian"
                                        name="time"
                                        InputProps={{
                                          startAdornment: (
                                            <InputAdornment position="start">tháng</InputAdornment>
                                          ),
                                        }}
                                        type="number"
                                      />
                                    </Grid>
                                  </Grid>
                                </Stack>
                              </Grid>
                              <Grid item md={6} xs={12}>
                                <TextField
                                  defaultValue={pack.description}
                                  onChange={handleDes}
                                  fullWidth
                                  label="Mô tả"
                                  name="description"
                                  multiline
                                  rows={4}
                                />
                              </Grid>
                            </Grid>
                          </CardContent>
                          <Divider />
                          <Stack
                            alignItems="center"
                            direction="row"
                            justifyContent="space-between"
                            sx={{ p: 2 }}
                          >
                            <Stack alignItems="center" direction="row" spacing={2}>
                              <Button
                                onClick={() => {
                                  console.log("Hello");
                                  handlePackageUpdate(pack.id);
                                }}
                                type="submit"
                                variant="contained"
                              >
                                Cập nhật
                              </Button>
                              <Button color="inherit" onClick={handlePackageClose}>
                                Hủy
                              </Button>
                            </Stack>
                            <div>
                              <Button
                                onClick={() => {
                                  console.log("Hello from delete");
                                  handlePackageDelete(pack.id);
                                }}
                                color="error"
                              >
                                Xóa
                              </Button>
                            </div>
                          </Stack>
                        </TableCell>
                      </TableRow>
                    )}
                  </Fragment>
                );
              }
            })}
          </TableBody>
        </Table>
      </Scrollbar>
      <TablePagination
        component="div"
        count={updatePackageQuery(packages).length}
        onPageChange={onPageChange}
        onRowsPerPageChange={onRowsPerPageChange}
        page={page}
        rowsPerPage={rowsPerPage}
        rowsPerPageOptions={[5, 10, 25]}
      />
    </div>
  );
};

PackageListTable.propTypes = {
  packages: PropTypes.array.isRequired,
  packagesCount: PropTypes.number.isRequired,
  onPageChange: PropTypes.func.isRequired,
  onRowsPerPageChange: PropTypes.func,
  page: PropTypes.number.isRequired,
  rowsPerPage: PropTypes.number.isRequired,
};
