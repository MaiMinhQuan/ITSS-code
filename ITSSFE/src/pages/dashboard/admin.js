import Head from "next/head";
import { subDays, subHours } from "date-fns";
import { Box, Container, Unstable_Grid2 as Grid } from "@mui/material";
import { Layout as DashboardLayout } from "src/layouts/dashboard/layout";
import { OverviewBudget } from "src/sections/overview/overview-budget";
import { OverviewLatestOrders } from "src/sections/overview/overview-latest-orders";
import { OverviewLatestProducts } from "src/sections/overview/overview-latest-products";
import { OverviewSales } from "src/sections/overview/overview-sales";
import { OverviewTasksProgress } from "src/sections/overview/overview-tasks-progress";
import { OverviewTotalCustomers } from "src/sections/overview/overview-total-customers";
import { OverviewTotalProfit } from "src/sections/overview/overview-total-profit";
import { OverviewTraffic } from "src/sections/overview/overview-traffic";

const date = new Date();

const now = new Date();

const Page = () => (
  <>
    <Head>
      <title>Overview</title>
    </Head>
    <Box
      component="main"
      sx={{
        flexGrow: 1,
        // py: 8,
        pt: 0, // padding-top: 0
        pb: 8, // giữ padding-bottom nếu muốn
      }}
    >
      <Container maxWidth="xl">
        <Grid container spacing={3}>
          {/* <Grid xs={12} sm={6} lg={4}>
            <OverviewBudget difference={8} positive sx={{ height: "100%" }} value="980.000.000đ" />
          </Grid>
          <Grid xs={12} sm={6} lg={4}>
            <OverviewTotalCustomers
              difference={10}
              positive={true}
              sx={{ height: "100%" }}
              value="500"
            />
          </Grid>
          <Grid xs={12} sm={6} lg={4}>
            <OverviewTotalProfit sx={{ height: "100%" }} value="100.000.000đ" />
          </Grid> */}
          <Grid xs={12} lg={6}>
            <OverviewSales
              chartSeries={[
                {
                  name: "2025",
                  data: [15, 12, 18, 20, 14, 16, 19, 11, 17, 13, 10, 15],
                },
                {
                  name: "2024",
                  data: [12, 11, 4, 6, 2, 9, 9, 10, 11, 12, 13, 13],
                },
              ]}
              sx={{ height: "100%" }}
              type="line"
            />
          </Grid>
          <Grid xs={12} lg={6}>
            <OverviewSales
              chartSeries={[
                {
                  name: "2025",
                  data: [15, 12, 18, 20, 14, 16, 19, 11, 17, 13, 10, 15],
                },
                // {
                //   name: "2024",
                //   data: [12, 11, 4, 6, 2, 9, 9, 10, 11, 12, 13, 13],
                // },
              ]}
              sx={{ height: "100%" }}
              type="radar"
            />
          </Grid>
          <Grid xs={12} md={6} lg={4}>
            <OverviewLatestProducts
              products={[
                {
                  id: "5ece2c077e39da27658aa8a9",
                  image: "/assets/equipments/treadmill.jpg",
                  name: "Máy chạy bộ",
                  updatedAt: subHours(now, 6).getTime(),
                },
                {
                  id: "5ece2c0d16f70bff2cf86cd8",
                  image: "/assets/equipments/dumbbell.jpg",
                  name: "Tạ đơn",
                  updatedAt: subDays(subHours(now, 8), 2).getTime(),
                },
                {
                  id: "b393ce1b09c1254c3a92c827",
                  image: "/assets/equipments/exercise-bike.jpg",
                  name: "Xe đạp tập thể dục",
                  updatedAt: subDays(subHours(now, 1), 1).getTime(),
                },
                {
                  id: "bcad5524fe3a2f8f8620ceda",
                  image: "/assets/equipments/full-body.jpg",
                  name: "Máy tập toàn thân",
                  updatedAt: subDays(subHours(now, 5), 6).getTime(),
                },
              ]}
              sx={{ height: "100%" }}
            />
          </Grid>
          <Grid xs={12} md={12} lg={8}>
            <OverviewLatestOrders
              orders={[
                {
                  id: "f69f88012978187a6c12897f",
                  ref: "DEV1049",
                  amount: 30.5,
                  customer: {
                    name: "Trần Lập",
                  },
                  createdAt: "2025-04-14", //1555016400000
                  package: "Gói Senior",
                },
                {
                  id: "9eaa1c7dd4433f413c308ce2",
                  ref: "DEV1048",
                  amount: 25.1,
                  customer: {
                    name: "Trần Châu",
                  },
                  createdAt: "2025-04-13",
                  package: "Gói Family",
                },
                {
                  id: "01a5230c811bd04996ce7c13",
                  ref: "DEV1047",
                  amount: 10.99,
                  customer: {
                    name: "Trần Minh",
                  },
                  createdAt: "2025-04-13",
                  package: "Gói Premium",
                },
                {
                  id: "1f4e1bd0a87cea23cdb83d18",
                  ref: "DEV1046",
                  amount: 96.43,
                  customer: {
                    name: "Phạm Huy",
                  },
                  createdAt: "2025-04-13",
                  package: "Gói VIP",
                },
                {
                  id: "9f974f239d29ede969367103",
                  ref: "DEV1045",
                  amount: 32.54,
                  customer: {
                    name: "Quang Nguyễn",
                  },
                  createdAt: "2025-04-11",
                  package: "Gói Basic",
                },
              ]}
              sx={{ height: "100%" }}
            />
          </Grid>
        </Grid>
      </Container>
    </Box>
  </>
);

Page.getLayout = (page) => <DashboardLayout>{page}</DashboardLayout>;

export default Page;
