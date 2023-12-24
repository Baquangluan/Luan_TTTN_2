import React from "react";
import { Admin, Resource } from "react-admin";
import AdminPanel from "./component/AdminPanel";
import {
  listCategory,
  editCategory,
  createCategory,
} from "./component/Category";

import { listProduct, editProduct, CreateProduct } from "./component/Products";

import dataProvider from "./component/customDataProvider";
import { CreateUser,editUser, listUser } from "./component/User";
import { createOrder, editOrder, listOrder } from "./component/Order";
import { CreateSlider,  editSlider, listSlider } from "./component/Slider";
import { createBrand, editBrand, listBrand } from "./component/Brand";

const App = () => (
  <Admin dashboard={AdminPanel} dataProvider={dataProvider}>
    <Resource
      name="categories"
      list={listCategory}
      edit={editCategory}
      create={createCategory}
    />
        <Resource
      name="brand"
      list={listBrand}
      edit={editBrand}
      create={createBrand}
    />
    <Resource
      name="products"
      list={listProduct}
      edit={editProduct}
      create={CreateProduct}
    />
    <Resource
      name="users"
      list={listUser}
      edit={editUser}
      create={CreateUser}
    />
    <Resource
      name="orders"
      list={listOrder}
      edit={editOrder}
      create={createOrder}
    />
     <Resource
      name="sliders"
      list={listSlider}
      edit={editSlider}
      create={CreateSlider}
    />
  </Admin>
);

export default App;
