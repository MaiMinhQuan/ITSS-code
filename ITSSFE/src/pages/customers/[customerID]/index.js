import { useCallback, useEffect, useState } from "react";
import NextLink from "next/link";
import Head from "next/head";
import { useRouter } from "next/router";
import ArrowLeftIcon from "@untitled-ui/icons-react/build/esm/ArrowLeft";
import ChevronDownIcon from "@untitled-ui/icons-react/build/esm/ChevronDown";
import Edit02Icon from "@untitled-ui/icons-react/build/esm/Edit02";
import {
  Avatar,
  Box,
  Button,
  Chip,
  Container,
  Divider,
  Link,
  Stack,
  SvgIcon,
  Tab,
  Tabs,
  Typography,
  Unstable_Grid2 as Grid,
} from "@mui/material";
import customersApi from "src/api/customers";
import { useMounted } from "src/hooks/use-mounted";
import { usePageView } from "src/hooks/use-page-view";
import { Layout as DashboardLayout } from "src/layouts/dashboard/layout";
import { paths } from "src/paths";
import { UserBasicDetails } from "src/sections/user/user-basic-details";
import { UserDataManagement } from "src/sections/user/user-data-management";
import { UserCalendar } from "src/sections/user/user-calendar-activity";
import { UserMember } from "src/sections/user/user-member";
import { UserLogs } from "src/sections/user/user-logs";
import { getInitials } from "src/utils/get-initials";
import packagesApi from "src/api/packages/index.js";

const tabs = [
  { label: "Thông tin chi tiết", value: "details" },
  { label: "Hoạt động", value: "logs" },
];

const useCustomer = () => {
  const route = useRouter();
  const isMounted = useMounted();
  const [customer, setCustomer] = useState(null);

  const getCustomer = useCallback(async () => {
    try {
      const customerId = route.query.customerID;
      const response = await customersApi.getCustomerById(customerId);
      if (isMounted()) {
        setCustomer(response);
      }
    } catch (err) {
      console.error(err);
    }
  }, [isMounted]);

  useEffect(() => {
    getCustomer();
  }, [getCustomer]);

  return customer;
};

const useLogs = (register) => {
  const route = useRouter(); // Thêm useRouter để lấy route
  const isMounted = useMounted();
  const [logs, setLogs] = useState([]);
  //console.log("register in useLogs 1", register);

  const getLogs = useCallback(async () => {
    try {
      const customerId = route.query.customerID;
      const response_register = await customersApi.getRegisterById(customerId);
      console.log("response_register", response_register);
      const response = await customersApi.getProcessById(response_register.id);
      console.log("logs123: ", response);
      if (isMounted()) {
        setLogs(response);
      }
    } catch (err) {
      console.error(err);
    }
  }, []);

  const addLog = useCallback(
    async (newLog) => {
      try {
        //const { customerId } = route.query;
        console.log("newLog in addLog", newLog);
        const customerId = route.query.customerID; // Sử dụng route để lấy customerID
        const response = await customersApi.addProcessById(customerId, newLog);
        if (isMounted.current) {
          setLogs((prevLogs) => [newLog, ...prevLogs]);
        }
      } catch (err) {
        console.error(err);
      }
    },
    [isMounted, setLogs]
  );

  useEffect(() => {
    getLogs();
  }, []);

  useEffect(() => {
    getLogs();
  }, [getLogs]);

  return { logs, addLog, getLogs };
};

const useRegister = () => {
  const route = useRouter();
  const isMounted = useMounted();
  const [register, setRegister] = useState(null);

  const getRegister = useCallback(async () => {
    try {
      const customerId = route.query.customerID;
      const response = await customersApi.getRegisterById(customerId);
      const response_package = await packagesApi.getPackageById(response.my_package_id);
      //console.log("response_package", response_package);
      response.time = response_package.time;
      if (isMounted()) {
        setRegister(response);
      }
    } catch (err) {
      console.error(err);
    }
  }, [isMounted]);

  useEffect(() => {
    getRegister();
  }, [getRegister]);

  return register;
};

const Page = () => {
  const [currentTab, setCurrentTab] = useState("details");
  const customer = useCustomer();
  const register = useRegister();
  //console.log("register in Page", register);
  const { logs, addLog, getLogs } = useLogs(register);
  const registerId = register ? register.id : null;
  console.log("logs in Page", logs);
  // console.log("Hello");
  const role = "ADMIN";

  usePageView();

  const handleTabsChange = useCallback((event, value) => {
    setCurrentTab(value);
  }, []);

  if (!customer) {
    return null;
  }

  return (
    <>
      <Head>
        <title>Dashboard: Thông tin khách hàng</title>
      </Head>
      <Box
        component="main"
        sx={{
          flexGrow: 1,
          py: 8,
        }}
      >
        <Container maxWidth="xl">
          <Stack spacing={4}>
            <Stack spacing={4}>
              <div>
                <Link
                  color="text.primary"
                  component={NextLink}
                  href={paths.customers.index}
                  sx={{
                    alignItems: "center",
                    display: "inline-flex",
                  }}
                  underline="hover"
                >
                  <SvgIcon sx={{ mr: 1 }}>
                    <ArrowLeftIcon />
                  </SvgIcon>
                  <Typography variant="subtitle2">Danh sách khách hàng</Typography>
                </Link>
              </div>
              <Stack
                alignItems="flex-start"
                direction={{
                  xs: "column",
                  md: "row",
                }}
                justifyContent="space-between"
                spacing={4}
              >
                <Stack alignItems="center" direction="row" spacing={2}>
                  <Avatar
                    src={`/assets/avatars/${customer.avatar}`}
                    sx={{
                      height: 64,
                      width: 64,
                    }}
                  >
                    {getInitials(customer.first_name + " " + customer.last_name)}
                  </Avatar>
                  <Stack spacing={1}>
                    <Typography variant="h4">
                      {customer.first_name} {customer.last_name}
                    </Typography>
                  </Stack>
                </Stack>
                {role === "ADMIN" && (
                  <Stack alignItems="center" direction="row" spacing={2}>
                    <Button
                      color="inherit"
                      component={NextLink}
                      endIcon={
                        <SvgIcon>
                          <Edit02Icon />
                        </SvgIcon>
                      }
                      href={paths.customers.edit(customer.id)}
                    >
                      Cập nhật
                    </Button>
                  </Stack>
                )}
              </Stack>
              <div>
                <Tabs
                  indicatorColor="primary"
                  onChange={handleTabsChange}
                  scrollButtons="auto"
                  sx={{ mt: 3 }}
                  textColor="primary"
                  value={currentTab}
                  variant="scrollable"
                >
                  {tabs.map((tab) => (
                    <Tab key={tab.value} label={tab.label} value={tab.value} />
                  ))}
                </Tabs>
                <Divider />
              </div>
            </Stack>
            {currentTab === "details" && (
              <div>
                <Stack spacing={4}>
                  <UserBasicDetails
                    address={customer.address}
                    gender={customer.gender}
                    birthday={customer.birth.slice(0, 10)}
                    email={customer.gmail}
                    phone={customer.phone}
                    role={customer.role}
                  />
                  {register && <UserMember register={register} />}
                  {/* <UserDataManagement id={customer.id} /> */}
                </Stack>
              </div>
            )}

            {currentTab === "logs" && (
              <Stack spacing={4}>
                <UserCalendar activity={logs} />
                <UserLogs
                  register={register}
                  logs={logs}
                  addLog={addLog}
                  getLogs={getLogs}
                  registerId={registerId}
                />
              </Stack>
            )}
          </Stack>
        </Container>
      </Box>
    </>
  );
};

Page.getLayout = (page) => <DashboardLayout>{page}</DashboardLayout>;

export default Page;
