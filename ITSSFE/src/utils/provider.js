import React from "react";
import { Toaster } from "react-hot-toast";

const Provider = ({ children }) => {
  return (
    <>
      <Toaster
        position="top-right"
        toastOptions={{
          duration: 3000,
          style: {
            background: "#333",
            color: "#fff",
          },
        }}
      />
      {children}
    </>
  );
};

export default Provider;
