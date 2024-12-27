import React, { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "../components/Navbar";
import Profile from "../components/Profile";

const ProfileContainer = () => {
    const [user, setUser] = useState({
        id: null,
        first_name: "",
        last_name: "",
        email: "",
        password: "",
        birthdate: "",
        profilePicUrl: "",
        bio: "",
    });

    const [isEditing, setIsEditing] = useState(false);
    const [isLoading, setIsLoading] = useState(true);
    const [error, setError] = useState(null);

    // Fetch user profile
    useEffect(() => {
        const fetchUser = async () => {
            try {
                // Fetch user ID from the session (backend)
                const sessionResponse = await axios.get("http://localhost:8080/api/session/userId");
                const userId = sessionResponse.data.userId;

                if (!userId) {
                    throw new Error("User ID not available");
                }

                // Fetch user data using the user ID
                const response = await axios.get(`http://localhost:8080/api/users/${userId}`);
                setUser(response.data);
            } catch (err) {
                setError(err.message || "Failed to fetch user data.");
            } finally {
                setIsLoading(false);
            }
        };

        fetchUser();
    }, []);

    // Toggle editing mode
    const handleEditToggle = () => {
        setIsEditing((prev) => !prev);
    };

    // Save updated profile
    const handleSave = async (updatedUser) => {
        try {
            const userId = updatedUser.id;
            await axios.put(`http://localhost:8080/api/users/${userId}`, updatedUser);
            setUser(updatedUser); // Update the user state with the new data
            setIsEditing(false); // Exit editing mode
            alert("Profile updated successfully");
        } catch (err) {
            setError(err.message || "Failed to update profile.");
        }
    };

    if (isLoading) return <div>Loading...</div>;
    if (error) return <div>Error: {error}</div>;

    return (
        <div>
            <Navbar />
            <Profile user={user} isEditing={isEditing} onEditToggle={handleEditToggle} onSave={handleSave} />
        </div>
    );
};

export default ProfileContainer;
