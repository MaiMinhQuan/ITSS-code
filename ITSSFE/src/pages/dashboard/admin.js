import Head from "next/head";
// import { subDays, subHours } from "date-fns";
import { Box, Container, Unstable_Grid2 as Grid } from "@mui/material";
import { Layout as DashboardLayout } from "src/layouts/dashboard/layout";
import { OverviewBudget } from "src/sections/overview/overview-budget";
// import { OverviewLatestOrders } from "src/sections/overview/overview-latest-orders";
// import { OverviewLatestProducts } from "src/sections/overview/overview-latest-products";
import { OverviewSales } from "src/sections/overview/overview-sales";
import { OverviewTasksProgress } from "src/sections/overview/overview-tasks-progress";
import { OverviewTotalCustomers } from "src/sections/overview/overview-total-customers";
import { OverviewTotalProfit } from "src/sections/overview/overview-total-profit";
import { OverviewTraffic } from "src/sections/overview/overview-traffic";

const date = new Date();

const Page = () => (
  <>
    <Head>
      <title>Overview</title>
    </Head>
    <Box
      component="main"
      sx={{
        flexGrow: 1,
        py: 8,
      }}
    >
      <Container maxWidth="xl">
        <Grid container spacing={3}>
          <Grid xs={12} sm={6} lg={4}>
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
          </Grid>
          <Grid xs={12} lg={12}>
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
            />
          </Grid>
        </Grid>
      </Container>
    </Box>
  </>
);

Page.getLayout = (page) => <DashboardLayout>{page}</DashboardLayout>;

export default Page;
