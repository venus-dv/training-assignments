import React, { useState } from "react";
import { TextField, Button, Typography, Container } from "@mui/material";

const Profile = ({ user, isEditing, onEditToggle, onSave }) => {
    const [editedUser, setEditedUser] = useState(user);

    // Handle input changes
    const handleChange = (e) => {
        const { name, value } = e.target;
        setEditedUser((prev) => ({ ...prev, [name]: value }));
    };

    // Handle form submission
    const handleSubmit = (e) => {
        e.preventDefault();
        onSave(editedUser);
    };

    return (
        <Container maxWidth="sm">
            <Typography variant="h4" component="h1" gutterBottom>
                {isEditing ? "Edit Profile" : "Profile"}
            </Typography>
            {isEditing ? (
                <form onSubmit={handleSubmit}>
                    <TextField
                        label="First Name"
                        name="first_name"
                        value={editedUser.first_name}
                        onChange={handleChange}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Last Name"
                        name="last_name"
                        value={editedUser.last_name}
                        onChange={handleChange}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Email"
                        name="email"
                        value={editedUser.email}
                        onChange={handleChange}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Bio"
                        name="bio"
                        value={editedUser.bio}
                        onChange={handleChange}
                        fullWidth
                        margin="normal"
                    />
                    <TextField
                        label="Birthdate"
                        name="birthdate"
                        value={editedUser.birthdate}
                        onChange={handleChange}
                        fullWidth
                        margin="normal"
                    />
                    <Button type="submit" variant="contained" color="primary">
                        Save
                    </Button>
                    <Button variant="text" onClick={onEditToggle}>
                        Cancel
                    </Button>
                </form>
            ) : (
                <div>
                    <Typography variant="body1">Name: {user.first_name} {user.last_name}</Typography>
                    <Typography variant="body1">Email: {user.email}</Typography>
                    <Typography variant="body1">Bio: {user.bio}</Typography>
                    <Typography variant="body1">Birthdate: {user.birthdate}</Typography>
                    <Button variant="contained" color="primary" onClick={onEditToggle}>
                        Edit Profile
                    </Button>
                </div>
            )}
        </Container>
    );
};

export default Profile;
