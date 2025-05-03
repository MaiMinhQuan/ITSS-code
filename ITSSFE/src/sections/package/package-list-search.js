import { useCallback, useMemo, useRef, useState } from "react";
import PropTypes from "prop-types";
import SearchMdIcon from "@untitled-ui/icons-react/build/esm/SearchMd";
import { Box, Chip, Divider, Input, Stack, SvgIcon, Typography } from "@mui/material";
import { MultiSelect } from "src/components/multi-select";
import { useUpdateEffect } from "src/hooks/use-update-effect";

export const PackageListSearch = (props) => {
  const { onFiltersChange, setQuery1, ...other } = props;
  const queryRef = useRef(null);
  const [query, setQuery] = useState("");
  const [chips, setChips] = useState([]);

  const handleChipsUpdate = useCallback(() => {
    const filters = {
      name: undefined,
      category: [],
      status: [],
      inStock: undefined,
    };

    chips.forEach((chip) => {
      switch (chip.field) {
        case "name":
          // There will (or should) be only one chips with field "name"
          // so we can set up it directly
          filters.name = chip.value;
          break;
        case "category":
          filters.category.push(chip.value);
          break;
        case "status":
          filters.status.push(chip.value);
          break;
        case "inStock":
          // The value can be "available" or "outOfStock" and we transform it to a boolean
          filters.inStock = chip.value === "available";
          break;
        default:
          break;
      }
    });

    onFiltersChange?.(filters);
  }, [chips, onFiltersChange]);

  useUpdateEffect(() => {
    handleChipsUpdate();
  }, [chips, handleChipsUpdate]);

  const handleQueryChange = useCallback((event) => {
    event.preventDefault();
    const query = event.target.value;
    //console.log("query in package: ", query);
    setQuery1(query);
    setQuery(queryRef.current?.value || "");
  }, []);

  return (
    <div {...other}>
      <Stack
        alignItems="center"
        component="form"
        direction="row"
        onSubmit={handleQueryChange}
        spacing={2}
        sx={{ p: 2 }}
      >
        <SvgIcon>
          <SearchMdIcon />
        </SvgIcon>
        <Input
          disableUnderline
          fullWidth
          inputProps={{ ref: queryRef }}
          placeholder="Tìm kiếm theo tên gói tập"
          sx={{ flexGrow: 1 }}
          value={query}
          onChange={handleQueryChange}
        />
      </Stack>
    </div>
  );
};

PackageListSearch.propTypes = {
  onFiltersChange: PropTypes.func,
};
