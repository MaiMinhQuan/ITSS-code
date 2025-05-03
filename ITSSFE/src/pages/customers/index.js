import { useCallback, useEffect, useState } from "react";
import Head from "next/head";
import Download01Icon from "@untitled-ui/icons-react/build/esm/Download01";
import PlusIcon from "@untitled-ui/icons-react/build/esm/Plus";
import Upload01Icon from "@untitled-ui/icons-react/build/esm/Upload01";
import { Box, Button, Card, Container, Dialog, Stack, SvgIcon, Typography } from "@mui/material";
import customersApi from "src/api/customers";
import { useMounted } from "src/hooks/use-mounted";
import { usePageView } from "src/hooks/use-page-view";
import { Layout as DashboardLayout } from "src/layouts/dashboard/layout";
import { UserListSearch } from "src/sections/user/user-list-search";
import { UserListTable } from "src/sections/user/user-list-table";
import { UserEditForm } from "src/sections/user/user-edit-form";
import { UserCreateForm } from "src/sections/user/user-create-form.js";
import { set } from "nprogress";

const useSearch = () => {
  const [search, setSearch] = useState({
    filters: {
      query: undefined,
      role: undefined,
    },
    page: 0,
    rowsPerPage: 5,
    sortBy: "updatedAt",
    sortDir: "desc",
  });

  const handleQueryChange = useCallback((query) => {
    setSearch((prevState) => ({
      ...prevState,
      filters: {
        ...prevState.filters,
        query,
      },
    }));
  }, []);

  return {
    search,
    updateSearch: setSearch,
    handleQueryChange,
  };
};

const useCustomers = (search) => {
  const isMounted = useMounted();
  const [state, setState] = useState({
    users: [],
    usersCount: 0,
  });

  const getCustomers = useCallback(async () => {
    try {
      const response = await customersApi.getCustomers();
      if (isMounted()) {
        setState({
          users: response.data,
          usersCount: response.count,
          userStore: response.data,
        });
      }
    } catch (err) {
      console.error(err);
    }
  }, [search, isMounted]);

  const deleteCustomer = useCallback(
    async (customerId) => {
      try {
        await customersApi.deleteCustomerById(customerId);
        getCustomers();
      } catch (err) {
        console.error(err);
      }
    },
    [getCustomers]
  );

  useEffect(() => {
    getCustomers();
  }, [search, getCustomers]);

  return {
    state,
    deleteCustomer,
    setState,
  };
};

const Page = () => {
  const [openModal, setOpenModal] = useState(false);
  const [openModalCreate, setOpenModalCreate] = useState(false);
  const { search, updateSearch } = useSearch();
  const { state, deleteCustomer, setState } = useCustomers(search);
  //console.log("state before", state);
  const [query, setQuery] = useState("");
  // setState(0);
  // console.log("state after", state);
  // const [state1, setState1] = useState(state);
  // console.log("state1", state1);

  usePageView();

  const handleFiltersChange = useCallback(
    (filters) => {
      updateSearch((prevState) => ({
        ...prevState,
        filters,
      }));
    },
    [updateSearch]
  );

  const handleSortChange = useCallback(
    (sort) => {
      updateSearch((prevState) => ({
        ...prevState,
        sortBy: sort.sortBy,
        sortDir: sort.sortDir,
      }));
    },
    [updateSearch]
  );

  const handlePageChange = useCallback(
    (event, page) => {
      updateSearch((prevState) => ({
        ...prevState,
        page,
      }));
    },
    [updateSearch]
  );

  const handleRowsPerPageChange = useCallback(
    (event) => {
      updateSearch((prevState) => ({
        ...prevState,
        rowsPerPage: parseInt(event.target.value, 10),
      }));
    },
    [updateSearch]
  );

  const handleDeleteCustomer = (customerId) => {
    deleteCustomer(customerId);
  };

  const onCloseModel = () => {
    setOpenModal(false);
  };

  const onCloseModelCreate = () => {
    setOpenModalCreate(false);
  };

  // const updateStateByQuery = (query) => {
  //   console.log("state1 in function", state1);
  //   const searchTerms = query.toLowerCase().trim().split(/\s+/);
  //   console.log("state", state.userStore);
  //   //Lọc danh sách user
  //   const userList = state.userStore || [];
  //   const userQuery = userList.filter((user) => {
  //     const fullName = `${user.first_name} ${user.last_name}`.toLowerCase();
  //     return searchTerms.every(
  //       (term) =>
  //         fullName.includes(term) ||
  //         user.first_name.toLowerCase().includes(term) ||
  //         user.last_name.toLowerCase().includes(term)
  //     );
  //   });

  //   setState((prevState) => ({
  //     ...prevState,
  //     users: userQuery,
  //     usersCount: userQuery.length,
  //   }));
  //   console.log("userQuery", userQuery);
  // };

  return (
    <>
      <Head>
        <title>Khách hàng | EliteGym System</title>
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
            <Stack direction="row" justifyContent="space-between" spacing={4}>
              <Stack spacing={1}>
                <Typography variant="h4">Khách hàng</Typography>
                {/* <Stack alignItems="center" direction="row" spacing={1}>
                  <Button
                    color="inherit"
                    size="small"
                    startIcon={
                      <SvgIcon>
                        <Upload01Icon />
                      </SvgIcon>
                    }
                  >
                    Import
                  </Button>
                  <Button
                    color="inherit"
                    size="small"
                    startIcon={
                      <SvgIcon>
                        <Download01Icon />
                      </SvgIcon>
                    }
                  >
                    Export
                  </Button>
                </Stack> */}
              </Stack>
              <Stack alignItems="center" direction="row" spacing={3}>
                <Button
                  startIcon={
                    <SvgIcon>
                      <PlusIcon />
                    </SvgIcon>
                  }
                  variant="contained"
                  onClick={() => {
                    setOpenModalCreate(true);
                  }}
                >
                  Thêm mới
                </Button>
              </Stack>
            </Stack>
            <Card>
              <UserListSearch
                onFiltersChange={handleFiltersChange}
                onSortChange={handleSortChange}
                sortBy={search.sortBy}
                sortDir={search.sortDir}
                updateQuery={search.handleQueryChange} // Change prop name here
                // state={state} // Pass the state to the search component
                // setState={setState} // Pass the setState function to the search component
                //updateStateByQuery={updateStateByQuery} // Add this line to pass the function
                setQuery={setQuery} // Add this line to pass the function
              />

              <UserListTable
                query={query}
                users={state.users}
                usersCount={state.usersCount}
                onPageChange={handlePageChange}
                onRowsPerPageChange={handleRowsPerPageChange}
                rowsPerPage={search.rowsPerPage}
                page={search.page}
                handleDeleteUser={handleDeleteCustomer}
              />
            </Card>
          </Stack>

          <Dialog open={openModal} onClose={onCloseModel}>
            <UserEditForm onClose={onCloseModel}></UserEditForm>
          </Dialog>
          <Dialog open={openModalCreate} onClose={onCloseModelCreate}>
            <UserCreateForm onClose={onCloseModelCreate}></UserCreateForm>
          </Dialog>
        </Container>
      </Box>
    </>
  );
};

Page.getLayout = (page) => <DashboardLayout>{page}</DashboardLayout>;

export default Page;
