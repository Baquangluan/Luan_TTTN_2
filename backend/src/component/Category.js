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
} from "react-admin";

export const listCategory = (props) => (
  <List {...props}>
    <Datagrid>
      <TextField source="id" />
      <TextField source="name" />
      <TextField source="slug" />
      <TextField source="image" />
      <TextField source="sort_order" />
      <TextField source="parent_id" />
      <TextField source="metakey" />
      <TextField source="metadesc" />
      <TextField source="created_at" />
      <TextField source="updated_at" />
      <TextField source="created_by" />
      <TextField source="updated_by" />
      <TextField source="status" />
      <EditButton />
      <DeleteButton />
    </Datagrid>
  </List>
);

export const editCategory = (props) => {
  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  return (
  <Edit {...props}>
    <SimpleForm>
      <TextInput source="name" />
      <TextInput source="slug" />
      <TextInput source="image" />
      <TextInput source="sort_order" />
      <TextInput source="parent_id" />
      <TextInput source="metakey" />
      <TextInput source="metadesc" />
      {/* You can choose to include or exclude the following fields based on your needs */}
      {/* <TextInput source="created_at" /> */}
      {/* <TextInput source="updated_at" /> */}
      {/* <TextInput source="created_by" /> */}
      {/* <TextInput source="updated_by" /> */}
      <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
        <TextInput source="update_at" defaultValue={getCurrentDateTime()} />
        <TextInput source="created_by" defaultValue={getCurrentDateTime()} />
        <TextInput source="updated_by" defaultValue={getCurrentDateTime()} />
      <TextInput source="status" />
    </SimpleForm>
  </Edit>
);
};

export const createCategory = (props) => {
  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  return (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="name" />
      <TextInput source="slug" />
      <TextInput source="image" />
      <TextInput source="sort_order" />
      <TextInput source="parent_id" />
      <TextInput source="metakey" />
      <TextInput source="metadesc" />
      {/* You can choose to include or exclude the following fields based on your needs */}
      {/* <TextInput source="created_at" /> */}
      {/* <TextInput source="updated_at" /> */}
      {/* <TextInput source="created_by" /> */}
      {/* <TextInput source="updated_by" /> */}
      <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
        <TextInput source="update_at" defaultValue={getCurrentDateTime()} />
        <TextInput source="created_by" defaultValue={getCurrentDateTime()} />
        <TextInput source="updated_by" defaultValue={getCurrentDateTime()} />
      <TextInput source="status" />
    </SimpleForm>
  </Create>
);
};
