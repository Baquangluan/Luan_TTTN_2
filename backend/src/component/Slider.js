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

export const listSlider = (props) => (
  <List {...props}>
    <Datagrid>
      <TextField source="id" />
      <TextField source="title" />
      <TextField source="link" />
      <TextField source="image" />
      <TextField source="sortOrder" />
      <TextField source="position" />
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

export const editSlider = (props) => {
  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  return (
  
  <Edit {...props}>
    <SimpleForm>
    <TextInput source="title" />
      <TextInput source="link" />
      <TextField source="image" />
      <TextInput source="sortOrder" />
      <TextInput source="position" />
      <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
      <TextInput source="updated_at" defaultValue={getCurrentDateTime()} />
      <TextInput source="status" />
      <TextInput source="image" />
    </SimpleForm>
  </Edit>
  );
};
export const  CreateSlider = (props) => {
  const notify = useNotify();
  const redirect = useRedirect();

  const imageUploadFormRef = useRef();

  const getCurrentDateTime = () => {
    const now = new Date();
    return now.toISOString();
  };
  
  const onSuccess = (data) => {
    notify(`Slider created successfully`);

    if (imageUploadFormRef.current) {
      imageUploadFormRef.current.handleImageUpload(data.image);
    }
    redirect("list", "sliders");
  };
  return (
    <Create {...props} mutationOptions={{ onSuccess }} redirect="sliders">
      <SimpleForm>
      <TextInput source="title" />
        <TextInput source="link" />
        <TextInput source="image" />
        <NumberInput source="sortOrder" />
        <NumberInput source="position" />
        <TextInput source="created_at" defaultValue={getCurrentDateTime()} />
        <TextInput source="updated_at" defaultValue={getCurrentDateTime()} />
        <NumberInput source="status" />
        <ImageUploadForm endpoint="http://localhost:8081/api/sliders" ref={imageUploadFormRef} />
      </SimpleForm>
    </Create>
  );
};

