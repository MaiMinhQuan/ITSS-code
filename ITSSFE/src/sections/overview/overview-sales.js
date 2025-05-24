import PropTypes from "prop-types";
import ArrowPathIcon from "@heroicons/react/24/solid/ArrowPathIcon";
import ArrowRightIcon from "@heroicons/react/24/solid/ArrowRightIcon";
import {
  Button,
  Card,
  CardActions,
  CardContent,
  CardHeader,
  Divider,
  SvgIcon,
} from "@mui/material";
import { alpha, useTheme } from "@mui/material/styles";
import { Chart } from "src/components/chart";

const useChartOptions = (type) => {
  const theme = useTheme();

  if (type === "radar") {
    return {
      chart: {
        background: "transparent",
        toolbar: {
          show: false,
        },
      },
      colors: ["#FF7F50", alpha("#FF7F50", 0.25)], // Màu sắc cho các series
      dataLabels: {
        enabled: true, // Hiển thị giá trị trên các điểm
      },
      fill: {
        opacity: 0.4, // Độ trong suốt của vùng radar
      },
      stroke: {
        width: 2, // Độ dày của đường nối
      },
      markers: {
        size: 4, // Kích thước các điểm trên radar
      },
      xaxis: {
        categories: [
          "Jan",
          "Feb",
          "Mar",
          "Apr",
          "May",
          "Jun",
          "Jul",
          "Aug",
          "Sep",
          "Oct",
          "Nov",
          "Dec",
        ], // Các danh mục trên trục X
        labels: {
          style: {
            colors: theme.palette.text.secondary,
            fontSize: "12px",
          },
        },
      },
      yaxis: {
        show: false, // Ẩn trục Y (không cần thiết cho radar)
      },
      legend: {
        show: true, // Hiển thị chú thích
        position: "bottom",
        labels: {
          colors: theme.palette.text.secondary,
        },
      },
      tooltip: {
        theme: "dark", // Tooltip với giao diện tối
        y: {
          formatter: (value) => `${value}.000.000đ`, // Định dạng giá trị
        },
      },
      grid: {
        show: true, // Hiển thị lưới
        borderColor: theme.palette.divider,
      },
    };
  }
  if (type === "bar" || type === "area") {
    return {
      chart: {
        background: "transparent",
        stacked: false,
        toolbar: {
          show: false,
        },
      },
      //colors: [theme.palette.primary.main, alpha(theme.palette.primary.main, 0.25)],
      colors: [alpha("#FF7F50", 0.9), alpha("#FF7F50", 0.25)], // Đổi sang màu đỏ
      dataLabels: {
        enabled: false,
      },
      fill: {
        opacity: 1,
        type: "solid",
      },
      grid: {
        borderColor: theme.palette.divider,
        strokeDashArray: 2,
        xaxis: {
          lines: {
            show: false,
          },
        },
        yaxis: {
          lines: {
            show: true,
          },
        },
      },
      legend: {
        show: false,
      },
      plotOptions: {
        bar: {
          columnWidth: "40px",
        },
      },
      stroke: {
        colors: ["transparent"],
        show: true,
        width: 2,
      },
      theme: {
        mode: theme.palette.mode,
      },
      xaxis: {
        axisBorder: {
          color: theme.palette.divider,
          show: true,
        },
        axisTicks: {
          color: theme.palette.divider,
          show: true,
        },
        categories: [
          "Jan",
          "Feb",
          "Mar",
          "Apr",
          "May",
          "Jun",
          "Jul",
          "Aug",
          "Sep",
          "Oct",
          "Nov",
          "Dec",
        ],
        labels: {
          offsetY: 5,
          style: {
            colors: theme.palette.text.secondary,
          },
        },
      },
      yaxis: {
        labels: {
          formatter: (value) => (value > 0 ? `${value}.000.000đ` : `${value}`),
          offsetX: -10,
          style: {
            colors: theme.palette.text.secondary,
          },
        },
      },
    };
  }
  if (type === "line") {
    return {
      chart: {
        background: "transparent",
        stacked: false,
        toolbar: {
          show: false,
        },
      },
      colors: [alpha("#FF7F50", 0.9), alpha("#FF7F50", 0.25)],
      dataLabels: {
        enabled: false,
      },
      fill: {
        opacity: 1,
        type: "solid",
      },
      grid: {
        borderColor: theme.palette.divider,
        strokeDashArray: 2,
        xaxis: {
          lines: {
            show: false,
          },
        },
        yaxis: {
          lines: {
            show: true,
          },
        },
      },
      legend: {
        show: false,
      },
      plotOptions: {
        bar: {
          columnWidth: "40px",
        },
      },
      // Sửa stroke cho line/area
      stroke: {
        colors:
          type === "line" || type === "area"
            ? [alpha("#FF7F50", 0.9), alpha("#FF7F50", 0.25)]
            : ["transparent"],
        show: true,
        width: 3,
        curve: "smooth", // Đường cong mượt cho line/area
      },
      theme: {
        mode: theme.palette.mode,
      },
      xaxis: {
        axisBorder: {
          color: theme.palette.divider,
          show: true,
        },
        axisTicks: {
          color: theme.palette.divider,
          show: true,
        },
        categories: [
          "Jan",
          "Feb",
          "Mar",
          "Apr",
          "May",
          "Jun",
          "Jul",
          "Aug",
          "Sep",
          "Oct",
          "Nov",
          "Dec",
        ],
        labels: {
          offsetY: 5,
          style: {
            colors: theme.palette.text.secondary,
          },
        },
      },
      yaxis: {
        labels: {
          formatter: (value) => (value > 0 ? `${value}.000.000đ` : `${value}`),
          offsetX: -10,
          style: {
            colors: theme.palette.text.secondary,
          },
        },
      },
    };
  }
};

export const OverviewSales = (props) => {
  const { chartSeries, sx, type } = props;
  const chartOptions = useChartOptions(type);

  return (
    <Card sx={sx}>
      <CardHeader
        // action={
        //   <Button
        //     color="inherit"
        //     size="small"
        //     startIcon={
        //       <SvgIcon fontSize="small">
        //         <ArrowPathIcon />
        //       </SvgIcon>
        //     }
        //   >
        //     Sync
        //   </Button>
        // }
        title={type === "radar" ? "Doanh thu hàng tháng" : "So sánh doanh thu"}
        // {type === "radar" ? title ="Doanh thu hàng tháng" : title ="So sánh doanh thu"}
      />
      <CardContent>
        <Chart height={350} options={chartOptions} series={chartSeries} type={type} width="100%" />
        {/* <Chart height={350} options={chartOptions} series={chartSeries} type="radar" width="100%" /> */}
        {type === "radar" ? "Đơn vị: triệu đồng" : ""}
      </CardContent>
      <Divider />
      {/* <CardActions sx={{ justifyContent: "flex-end" }}>
        <Button
          color="inherit"
          endIcon={
            <SvgIcon fontSize="small">
              <ArrowRightIcon />
            </SvgIcon>
          }
          size="small"
        >
          Overview
        </Button>
      </CardActions> */}
    </Card>
  );
};

OverviewSales.protoTypes = {
  chartSeries: PropTypes.array.isRequired,
  sx: PropTypes.object,
};
