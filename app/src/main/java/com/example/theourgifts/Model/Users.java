package com.example.theourgifts.Model;

public class Users {

        private String name, phone, password, image,address;

        public Users() {

        }

        public Users(String image) {
                this.image = image;
        }

        public Users(String name, String phone, String password,String address) {
                this.name = name;

                this.phone = phone;
                this.password = password;
                this.name = address;
        }

        public String getImage() {
                return image;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}

