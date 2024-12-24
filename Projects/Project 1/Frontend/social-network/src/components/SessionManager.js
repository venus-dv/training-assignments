import React, { useState } from 'react';
import { getSession, invalidateSession } from '../api/sessionApi';

const SessionManager = () => {
    const [sessionData, setSessionData] = useState(null);

    const handleGetSession = async () => {
        const data = await getSession();
        setSessionData(data);
    };

    const handleInvalidateSession = async () => {
        const data = await invalidateSession();
        alert(data);
        setSessionData(null);
    };

    return (
        <div>
            <button onClick={handleGetSession}>Get Session</button>
            <button onClick={handleInvalidateSession}>Invalidate Session</button>
            {sessionData && <p>Session: {sessionData}</p>}
        </div>
    );
};

export default SessionManager;
