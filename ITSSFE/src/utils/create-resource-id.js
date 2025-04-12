export const createResourceId = () => {
  const arr = new Uint8Array(12);
  window.crypto.getRandomValues(arr);
  return Array.from(arr, (v) => v.toString(16).padStart(2, "0")).join("");
};
/*
Đoạn code này định nghĩa một hàm createResourceId để 
tạo ra một ID ngẫu nhiên duy nhất.

Kết quả
Hàm trả về một chuỗi gồm 24 ký tự (12 byte x 2 ký tự/byte) đại diện cho một ID ngẫu nhiên.
Ví dụ: "a3f2c4d8e9b1f0a2c3d4e5f6"

*/
