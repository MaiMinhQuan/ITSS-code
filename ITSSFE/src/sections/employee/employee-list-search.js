import { useCallback, useRef, useState } from "react";
import PropTypes from "prop-types";
import SearchMdIcon from "@untitled-ui/icons-react/build/esm/SearchMd";
import {
  Box,
  Divider,
  InputAdornment,
  OutlinedInput,
  Stack,
  SvgIcon,
  Tab,
  Tabs,
  TextField,
} from "@mui/material";
import { useUpdateEffect } from "src/hooks/use-update-effect";
import { set } from "nprogress";

const tabs = [
  {
    label: "All",
    value: "ALL",
  },
  {
    label: "Quản lý",
    value: "MANAGER",
  },
  {
    label: "Chăm sóc khách hàng",
    value: "CUSTOMER_CARE",
  },
  {
    label: "Huấn luyện viên",
    value: "TRAINER",
  },
  {
    label: "Sale",
    value: "SALE",
  },
];

const sortOptions = [
  {
    label: "Name (a - z)",
    value: "name|asc",
  },
  {
    label: "Name (z - a)",
    value: "name|desc",
  },
  {
    label: "Role (highest)",
    value: "role|desc",
  },
  {
    label: "Role (lowest)",
    value: "role|asc",
  },
];

export const EmployeeListSearch = (props) => {
  const { onFiltersChange, onSortChange, sortBy, sortDir, setQuery, setRole } = props;
  const queryRef = useRef(null);
  const [currentTab, setCurrentTab] = useState("all");
  const [filters, setFilters] = useState({});

  const handleFiltersUpdate = useCallback(() => {
    onFiltersChange?.(filters);
  }, [filters, onFiltersChange]);

  useUpdateEffect(() => {
    handleFiltersUpdate();
  }, [filters, handleFiltersUpdate]);

  const handleTabsChange = useCallback((event, value) => {
    //console.log("Value in handleTabsChange", value); // In ra giá trị của value
    setRole(value); // Cập nhật giá trị role trong state cha

    setCurrentTab(value);
    // setFilters((prevState) => {
    //   const updatedFilters = {
    //     ...prevState,
    //     role: undefined,
    //   };

    //   if (value !== "all") {
    //     updatedFilters.role = value;
    //   }

    //   return updatedFilters;
    // });
  }, []);

  // const handleQueryChange = useCallback((event) => {
  //   event.preventDefault();
  //   setFilters((prevState) => ({
  //     ...prevState,
  //     query: queryRef.current?.value,
  //   }));
  // }, []);

  const handleQueryChange = useCallback((event) => {
    const query = event.target.value; // Lấy giá trị từ ô tìm kiếm
    // console.log("Query in handleQueryChange", query); // In ra giá trị query
    setQuery(query); // Cập nhật query vào state cha
    setFilters((prevState) => ({
      ...prevState,
      query, // Cập nhật query vào filters
    }));
  }, []);
  const handleSortChange = useCallback(
    (event) => {
      const [sortBy, sortDir] = event.target.value.split("|");

      onSortChange?.({
        sortBy,
        sortDir,
      });
    },
    [onSortChange]
  );

  return (
    <>
      <Tabs
        indicatorColor="primary"
        onChange={handleTabsChange}
        scrollButtons="auto"
        sx={{ px: 3 }}
        textColor="primary"
        value={currentTab}
        variant="scrollable"
      >
        {tabs.map((tab) => (
          <Tab key={tab.value} label={tab.label} value={tab.value} />
        ))}
      </Tabs>
      <Divider />
      <Stack alignItems="center" direction="row" flexWrap="wrap" spacing={3} sx={{ p: 3 }}>
        <Box component="form" onSubmit={handleQueryChange} sx={{ flexGrow: 1 }}>
          {/* <OutlinedInput
            defaultValue=""
            fullWidth
            inputProps={{ ref: queryRef }}
            placeholder="Search employee"
            startAdornment={
              <InputAdornment position="start">
                <SvgIcon>
                  <SearchMdIcon />
                </SvgIcon>
              </InputAdornment>
            }
          /> */}
          <OutlinedInput
            defaultValue=""
            fullWidth
            inputProps={{ ref: queryRef }}
            placeholder="Tìm kiếm nhân viên"
            startAdornment={
              <InputAdornment position="start">
                <SvgIcon>
                  <SearchMdIcon />
                </SvgIcon>
              </InputAdornment>
            }
            onChange={handleQueryChange} // Gọi handleQueryChange khi nhập
          />
        </Box>
        {/* <TextField
          label="Sort By"
          name="sort"
          onChange={handleSortChange}
          select
          SelectProps={{ native: true }}
          value={`${sortBy}|${sortDir}`}
        >
          {sortOptions.map((option) => (
            <option key={option.value} value={option.value}>
              {option.label}
            </option>
          ))}
        </TextField> */}
      </Stack>
    </>
  );
};

EmployeeListSearch.propTypes = {
  onFiltersChange: PropTypes.func,
  onSortChange: PropTypes.func,
  sortBy: PropTypes.string,
  sortDir: PropTypes.oneOf(["asc", "desc"]),
};
