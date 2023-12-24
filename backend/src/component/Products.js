import React, { useRef } from "react";
import {
  List,
  Datagrid,
  TextField,
  Edit,
  SimpleForm,
  EditButton,
  TextInput,
  NumberInput,
  Create,
  ReferenceInput,
  SelectInput,
  useNotify,
  useRedirect,
  DeleteButton,
} from "react-admin";


export const listProduct = (props) => (
  <List {...props}>
    <Datagrid style={{ overflowX: "auto" }}>
      <TextField source="id" />
      <TextField source="title" />
      <TextField source="slug" />
      <TextField source="price" />
      <TextField source="qty" />
      <TextField source="description" />
      <TextField source="category.name" />
      <TextField source="brand.name" />
      <TextField source="metakey" />
      <TextField source="metadesc" />
      <TextField source="created_at" />
      <TextField source="updated_at" />
      <TextField source="status" />
      <EditButton />
      <DeleteButton/>
    </Datagrid>
  </List>
);

export const editProduct = (props) => {
  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  return (
    <Edit {...props}>
      <SimpleForm>
        <TextInput source="title" />
        <TextInput source="slug" />
        <NumberInput source="price" />
        <NumberInput source="qty" />
        <TextInput source="description" multiline fullWidth />
        <ReferenceInput
          label="Category"
          source="category.id"
          reference="categories"
        >
          <SelectInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput
          label="Brand"
          source="brand.id"
          reference="brand"
        >
          <SelectInput optionText="name" />
        </ReferenceInput>
        <TextInput source="metakey" />
        <TextInput source="metadesc" />
        <TextInput source="updated_at" defaultValue={getCurrentDateTime()} />
        <NumberInput source="status" />
      </SimpleForm>
    </Edit>
  );
};

export const CreateProduct = (props) => {
  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  return (
    <Create {...props} >
      <SimpleForm>
      <TextInput source="title" />
        <TextInput source="slug" />
        <NumberInput source="price" />
        <NumberInput source="qty" />
        <TextInput source="description" multiline fullWidth />
        <ReferenceInput
          label="Category"
          source="category.id"
          reference="categories"
        >
          <SelectInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput
          label="Brand"
          source="brand.id"
          reference="brand"
        >
          <SelectInput optionText="name" />
        </ReferenceInput>
        <TextInput source="metakey" />
        <TextInput source="metadesc" />
        <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
        <NumberInput source="status" />
      </SimpleForm>
    </Create>
  );
};