import React, { useRef } from "react";
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
  useNotify,
  useRedirect,
  NumberInput,

} from "react-admin";
import ImageUploadForm from "./ImageUploadForm";

// ... Các components khác

export const listUser = (props) => (
  <List {...props}>
    <Datagrid>
      <TextField source="id" />
      <TextField source="email" />
      <TextField source="name" />
      <TextField source="image" />
      <TextField source="phone" />
      <TextField source="username" />
      <TextField source="password" />
      <TextField source="address" />

      <TextField source="roles" />
      <TextField source="created_at" />
      <TextField source="updated_at" />
      <TextField source="created_by" />
      <TextField source="updated_by" />
      <TextField source="status" />
      <EditButton />
      <DeleteButton/>
    </Datagrid>
  </List>
);

export const editUser = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="id" disabled />
      <TextInput source="name" />
      <TextInput source="email" />
      <TextInput source="image" />
      <TextInput source="phone" />
      <TextInput source="username" />
      <TextInput source="password" />
      <TextInput source="address" />
      <TextInput source="roles" />
      <TextInput source="created_at" />
      <TextInput source="updated_at" />
      <TextInput source="created_by" />
      <TextInput source="updated_by" />
      <TextInput source="status" />
    </SimpleForm>
  </Edit>
);

export const  CreateUser = (props) => {
  const notify = useNotify();
  const redirect = useRedirect();

  const imageUploadFormRef = useRef();

  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  
  const onSuccess = (data) => {
    notify(`Usser created successfully`);

    if (imageUploadFormRef.current) {
      imageUploadFormRef.current.handleImageUpload(data.image);
    }
    redirect("list", "users");
  };
  return (
    <Create {...props} mutationOptions={{ onSuccess }} redirect="users">
      <SimpleForm>
        <TextInput source="name" />
        <TextInput source="email" />
        <TextInput source="image" />
        <TextInput source="phone" />
        <TextInput source="username" />
        <TextInput source="password" />
        <TextInput source="address" />
        <TextInput source="roles" />
        <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
        <TextInput source="updated_at" defaultValue={getCurrentDateTime()} />
        <NumberInput source="status" />
        <ImageUploadForm endpoint="http://localhost:8081/api/users" ref={imageUploadFormRef} />
      </SimpleForm>
    </Create>
  );
};
