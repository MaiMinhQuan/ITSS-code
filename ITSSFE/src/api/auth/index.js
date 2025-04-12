/*
4. Tóm tắt
signIn: Xử lý đăng nhập bằng cách gửi email và mật khẩu đến API.
signUp: Xử lý đăng ký người dùng mới, kiểm tra email trùng lặp trước khi tạo tài khoản.
createResourceId: Được sử dụng để tạo ID ngẫu nhiên cho người dùng mới.
axios: Thư viện được sử dụng để gửi các yêu cầu HTTP đến API.

5. Ứng dụng
File này được sử dụng trong các phần khác của ứng dụng để thực hiện các thao tác xác thực, ví dụ:
Đăng nhập người dùng.
Đăng ký tài khoản mới.
Kiểm tra thông tin người dùng.
*/
import React from "react";
import axios from "axios";
import { createResourceId } from "src/utils/create-resource-id";
import { wait } from "src/utils/wait";
import usersApi from "../customers";
import { is } from "date-fns/locale";

class AuthApi {
  constructor(baseUrl) {
    this.baseUrl = baseUrl;
  }
  async signIn(request) {
    const { gmail, password } = request;
    return new Promise(async (resolve, reject) => {
      try {
        const response = await axios.post(`${this.baseUrl}/login`, { gmail, password });
        console.log(response);
        resolve(response.data);
      } catch (error) {
        console.error("Error while fetching users:", error);
        // window.location.href = "/500";
        return null;
      }
    });
  }

  async signUp(request) {
    const {
      gmail,
      firstName,
      lastName,
      confirmPass,
      password,
      phone,
      isDeleted,
      policy,
      birth,
      gender,
      avatar,
    } = request.gmail;
    console.log("request", request);

    return new Promise(async (resolve, reject) => {
      try {
        if (password !== confirmPass) {
          reject(new Error("Password does not match"));
          return;
        }
        let data = null;
        try {
          const response = await axios.get(`${this.baseUrl}/customer`);
          data = response.data;
        } catch (error) {
          console.error("Error while fetching users:", error);
          // window.location.href = "/500";
          return null;
        }
        let user = data.find((user) => user.gmail === gmail);

        if (user) {
          reject(new Error("User already exists"));
          return;
        }

        user = {
          //id: createResourceId(),
          avatar: avatar ? avatar : "avatar_default.jpg",
          gmail: gmail,
          first_name: firstName,
          last_name: lastName,
          password: password,
          role_id: 2,
          role_name: "CUSTOMER",
          phone: phone,
          is_deleted: isDeleted,
          birth: birth ? birth : new Date().toISOString().slice(0, 10),
          gender: gender,
        };

        try {
          const response = await axios.post(`${this.baseUrl}/register`, user);
          return resolve(response);
        } catch (error) {
          console.error("Error while creating user:", error);
          return null;
        }
      } catch (err) {
        console.error("[Auth Api]: ", err);
        reject(new Error("Internal server error"));
      }
    });
  }
}

export const authApi = new AuthApi("http://localhost:8081/user");
