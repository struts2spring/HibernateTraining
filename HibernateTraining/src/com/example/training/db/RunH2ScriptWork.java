package com.example.training.db;

import org.h2.tools.RunScript;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class RunH2ScriptWork implements Work {

    private static final Logger logger = LoggerFactory.getLogger(RunH2ScriptWork.class);

    private String scriptName;

    public RunH2ScriptWork(String scriptName) {
        this.scriptName = scriptName;
    }

    public void execute(Connection connection) throws SQLException {
        RunScript.execute(connection, getScriptReader());
    }

    private Reader getScriptReader() {
        InputStream stream = RunH2ScriptWork.class.getClassLoader().getResourceAsStream(scriptName);
        return new InputStreamReader(stream);
    }
}
