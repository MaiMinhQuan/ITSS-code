import React, { useCallback, useEffect, useState } from "react";
import Head from "next/head";
import { Box, Container, Unstable_Grid2 as Grid } from "@mui/material";

import { useMounted } from "src/hooks/use-mounted";
import { usePageView } from "src/hooks/use-page-view";
import { Layout as DashboardLayout } from "src/layouts/dashboard/layout";
import { UserCalendar } from "src/sections/user/user-calendar-activity";
import { UserMember } from "src/sections/user/user-member";
import { UserLogs } from "src/sections/user/user-logs";
import { PricingPlan } from "src/sections/overview/pricing-plan";
import { useAuth } from "src/hooks/use-auth";
import customersApi from "src/api/customers";

// const useLogs = (register) => {
//   const isMounted = useMounted();
//   const [logs, setLogs] = useState([]);
//   const getLogs = useCallback(async () => {
//     try {
//       const registerId = register.id;
//       const response = await customersApi.getProcessById(registerId);
//       console.log(response);
//       if (isMounted()) {
//         setLogs(response);
//       }
//     } catch (err) {
//       console.error(err);
//     }
//   }, [isMounted]);

//   useEffect(() => {
//     getLogs();
//   }, [getLogs]);

//   return logs;
// };

const useRegister = (customerId) => {
  const isMounted = useMounted();
  const [register, setRegister] = useState(null);

  const getRegister = useCallback(async () => {
    try {
      const response = await customersApi.getRegisterById(customerId);
      // console.log(response);
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

  // const [logs, setLogs] = useState([]);
  // const getLogs = useCallback(async () => {
  //   try {
  //     const registerId = register.id;
  //     const response = await customersApi.getProcessById(registerId);
  //     console.log(response);
  //     if (isMounted()) {
  //       setLogs(response);
  //     }
  //   } catch (err) {
  //     console.error(err);
  //   }
  // }, [isMounted]);

  // useEffect(() => {
  //   getLogs();
  // }, [getLogs]);

  const [logs, setLogs] = useState([]);
  //console.log("register in useLogs 1", register);

  const getLogs = useCallback(async () => {
    try {
      const response_register = await customersApi.getRegisterById(customerId);
      //console.log("response_register", response_register);
      const response = await customersApi.getProcessById(response_register.id);
      //console.log("logs123: ", response);
      if (isMounted()) {
        setLogs(response);
      }
    } catch (err) {
      console.error(err);
    }
  }, []);

  useEffect(() => {
    getLogs();
  }, []);

  useEffect(() => {
    getLogs();
  }, [getLogs]);

  return { register, logs };
};

const Page = () => {
  const user = useAuth().user;
  const { register, logs } = useRegister(user.id);
  console.log("Thong tin đăng ký: ", register);
  // const logs = useLogs(register);
  console.log("Logs: ", logs);

  usePageView();

  if (!user) {
    return null;
  }

  return (
    <>
      <Head>
        <title>Dashboard</title>
      </Head>
      <Box
        component="main"
        sx={{
          flexGrow: 1,
          py: 8,
        }}
      >
        <Container maxWidth="xl">
          {register === null ? (
            <Grid container spacing={4}>
              <Grid xs={12} md={4}>
                <PricingPlan
                  cta="Đăng ký"
                  currency=" VNĐ "
                  description="Tận hưởng hệ thống cơ sở vật chất và thiết bị cơ bản để khởi động hành trình fitness ngay hôm nay!"
                  features={[
                    "Sử dụng trang thiết bị gym cơ bản",
                    "Sử dụng phòng thay đồ",
                    "Hướng dẫn tập luyện cá nhân",
                  ]}
                  name="Basic"
                  price="50"
                  sx={{
                    height: "100%",
                    maxWidth: 460,
                    mx: "auto",
                  }}
                />
              </Grid>
              <Grid xs={12} md={4}>
                <PricingPlan
                  cta="Đăng ký"
                  currency=" VNĐ "
                  description="Nâng cấp trải nghiệm của bạn với các tiện ích bổ sung và dịch vụ để cải thiện quá trình tập luyện."
                  features={[
                    "Tất cả các tính năng của gói Basic",
                    "Sử dụng thiết bị gym cao cấp",
                    "Tham gia các lớp tập nhóm",
                    "Hướng dẫn dinh dưỡng",
                  ]}
                  name="Advanced"
                  popular
                  price="80"
                  sx={{
                    height: "100%",
                    maxWidth: 460,
                    mx: "auto",
                  }}
                />
              </Grid>
              <Grid xs={12} md={4}>
                <PricingPlan
                  cta="Đăng ký"
                  currency=" VNĐ "
                  description="Trải nghiệm phòng gym cao cấp với các đặc quyền và quyền truy cập độc quyền vào các tính năng nâng cao."
                  features={[
                    "Tất cả các tính năng của gói Advanced",
                    "Sử dụng phòng thay đồ VIP",
                    "Các buổi tập cá nhân 1 kèm 1",
                    "Chương trình tập luyện chuyên biệt",
                    "Ưu tiên đặt chỗ cho các lớp học và cơ sở vật chất",
                  ]}
                  name="Premium"
                  price="100"
                  sx={{
                    height: "100%",
                    maxWidth: 460,
                    mx: "auto",
                  }}
                />
              </Grid>
            </Grid>
          ) : (
            <Grid container spacing={4}>
              <Grid xs={12} md={7.5}>
                <UserCalendar activity={logs} />
              </Grid>
              <Grid xs={12} md={4.5} mt={4}>
                <UserMember register={register} />
              </Grid>

              <Grid xs={12}>
                <UserLogs register={register} logs={logs} />
              </Grid>
            </Grid>
          )}
        </Container>
      </Box>
    </>
  );
};

Page.getLayout = (page) => <DashboardLayout>{page}</DashboardLayout>;

export default Page;
