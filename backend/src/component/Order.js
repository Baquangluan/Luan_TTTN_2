import React from "react";
import {
  List,
  Datagrid,
  TextField,
  Edit,
  SimpleForm,
  EditButton,
  TextInput,
  Create,
  DeleteButton,
  NumberInput,
} from "react-admin";

export const listOrder = (props) => (
  <List {...props}>
    <Datagrid>
    <TextField source="title" />
      <TextField source="user_id" />
      <TextField source="name" />
      <TextField source="email" />
      <TextField source="phone" />
      <TextField source="address" />
      <TextField source="note" />
      <TextField source="created_at" />
      <TextField source="updated_at" />
      <TextField source="created_by" />
      <TextField source="updated_by" />
      <TextField source="status" />
      <TextField source="description" />
      <TextField source="fullname" />
      <TextField source="title" />
      <TextField source="total_money" />
      <EditButton />
      <DeleteButton />
    </Datagrid>
  </List>
);

export const editOrder = (props) => {

  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };

  
  return (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="title" />
      <TextInput source="user_id" />
      <TextInput source="name" />
      <TextInput source="email" />
      <TextInput source="phone" />
      <TextInput source="address" />
      <TextInput source="note" />
      <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
      <TextInput source="updated_at" defaultValue={getCurrentDateTime()} />
      <TextInput source="status" />
      <TextInput source="description" />
      <TextInput source="fullname" />
      <TextInput source="title" />
      <TextInput source="total_money" />
    </SimpleForm>
  </Edit>
)
  };

export const createOrder = (props) => {
  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  return (
  <Create {...props}>
    <SimpleForm>
    <TextInput source="title" />
      <TextInput source="user_id" />
      <TextInput source="name" />
      <TextInput source="email" />
      <TextInput source="phone" />
      <TextInput source="address" />
      <TextInput source="note" />
      <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
      <TextInput source="updated_at" defaultValue={getCurrentDateTime()} />
      <NumberInput source="status" />
      <TextInput source="description" />
      <TextInput source="fullname" />
      <NumberInput source="total_money" />
    </SimpleForm>
  </Create>
)
  };
