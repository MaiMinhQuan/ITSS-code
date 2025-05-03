import NextLink from "next/link";
import PropTypes from "prop-types";
import { Button, Card, CardContent, CardMedia, Link, Stack, Typography } from "@mui/material";
import { paths } from "src/paths";
import React, { useCallback, useEffect } from "react";

export const RoomCard = (props) => {
  const { room, onClickEdit, onClickDelete, onClick } = props;

  useEffect(() => {
    onClick();
  }, []);

  return (
    <Card variant="outlined">
      <CardMedia
        image={"/assets/rooms/room-3.png"}
        component={NextLink}
        href={paths.gyms.details(room.id || 1)}
        sx={{ height: 180 }}
      />
      <CardContent>
        <Link
          color="text.primary"
          underline="none"
          variant="subtitle1"
          component={NextLink}
          href={paths.gyms.details(room.id || 1)}
        >
          {room.name}
        </Link>
        <Typography color="text.secondary" sx={{ mt: 1 }} variant="body2">
          {room.address}
        </Typography>
        <Typography color="text.secondary" sx={{ mt: 1 }} variant="body2">
          {`Diện tích: ${room.acreage} m²`}
        </Typography>
      </CardContent>
      <Stack
        direction={{
          xs: "column",
          sm: "row",
        }}
        flexWrap="wrap"
        spacing={3}
        sx={{ p: 3 }}
      >
        <Button
          variant="contained"
          onClick={() => {
            onClick();
            onClickEdit(room);
          }}
        >
          Cập nhật
        </Button>
        <Button
          color="error"
          variant="contained"
          onClick={() => {
            onClick();
            onClickDelete(room.id);
          }}
        >
          Xóa
        </Button>
      </Stack>
    </Card>
  );
};

RoomCard.propTypes = {
  room: PropTypes.object.isRequired,
  onClickEdit: PropTypes.func,
  onClickDelete: PropTypes.func,
};
