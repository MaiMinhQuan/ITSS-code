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

const sortOptions = [
  {
    label: "Last update (newest)",
    value: "createdAt|desc",
  },
  {
    label: "Last update (oldest)",
    value: "createdAt|asc",
  },
];

export const UserListSearch = ({
  onFiltersChange,
  onSortChange,
  sortBy,
  sortDir,
  handleQueryChange,
  // state,
  // setState,
  setQuery,
}) => {
  // const { onFiltersChange, onSortChange, sortBy, sortDir, handleQueryChange } = props;
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
    setCurrentTab(value);
    setFilters((prevState) => {
      const updatedFilters = {
        ...prevState,
        role: undefined,
      };

      if (value !== "all") {
        updatedFilters.role = value;
      }

      return updatedFilters;
    });
  }, []);

  const updateQuery = useCallback(() => {
    const query = queryRef.current?.value;
    setQuery(query);
    // console.log("Query", query);
    // console.log("State in query", state);
    // //updateStateByQuery(query); // Call the callback function to update the state by query
    // const searchTerms = query.toLowerCase().trim().split(/\s+/);

    // const userList = state.userStore || [];
    // const userQuery = userList.filter((user) => {
    //   const fullName = `${user.first_name} ${user.last_name}`.toLowerCase();
    //   return searchTerms.every(
    //     (term) =>
    //       fullName.includes(term) ||
    //       user.first_name.toLowerCase().includes(term) ||
    //       user.last_name.toLowerCase().includes(term)
    //   );
    // });
    // console.log("userQuery", userQuery);
    // // setState(0);
    // // console.log("state1", state);

    // setState({
    //   users: userQuery,
    //   usersCount: userQuery.length,
    //   userStore: userList,
    // });

    // console.log("users", state);
    setFilters((prevState) => ({
      ...prevState,
      query,
    }));
    handleQueryChange?.(query); // Call the callback function to update the search query
  }, [handleQueryChange]);

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
      <Stack alignItems="center" direction="row" flexWrap="wrap" spacing={3} sx={{ p: 3 }}>
        <Box component="form" onSubmit={updateQuery} sx={{ flexGrow: 1 }}>
          <OutlinedInput
            defaultValue=""
            fullWidth
            inputProps={{ ref: queryRef }}
            placeholder="Tìm kiếm theo tên khách hàng"
            startAdornment={
              <InputAdornment position="start">
                <SvgIcon>
                  <SearchMdIcon />
                </SvgIcon>
              </InputAdornment>
            }
            onChange={updateQuery} // Change this line
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

UserListSearch.propTypes = {
  onFiltersChange: PropTypes.func,
  onSortChange: PropTypes.func,
  sortBy: PropTypes.string,
  sortDir: PropTypes.oneOf(["asc", "desc"]),
};
