import { common } from "@mui/material/colors";
import { alpha } from "@mui/material/styles";
import { error, indigo, info, neutral, success, warning } from "./colors";

export function createPalette() {
  return {
    action: {
      active: neutral[500],
      disabled: alpha(neutral[900], 0.38),
      disabledBackground: alpha(neutral[900], 0.12),
      focus: alpha(neutral[900], 0.16),
      hover: alpha(neutral[900], 0.04),
      selected: alpha(neutral[900], 0.12),
    },
    background: {
      default: common.white,
      paper: common.white,
    },
    divider: "#F2F4F7",
    error,
    info,
    mode: "light",
    neutral,
    // primary: indigo,
    primary: {
      main: "#FF7F50", // Màu chính (primary)
      light: "#FFA07A", // Màu sáng hơn (tùy chọn)
      dark: "#FF9A76", // Màu tối hơn (tùy chọn)
      contrastText: "#FFFFFF", // Màu chữ tương phản (tùy chọn)
    },
    success,
    text: {
      primary: neutral[900],
      secondary: neutral[500],
      disabled: alpha(neutral[900], 0.38),
    },
    warning,
  };
}
