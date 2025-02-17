package cn.yusiwen.whitespace;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * Goal which detects whitespace in all src/.../*.java and xml files.
 */
@Mojo(name = "verify", defaultPhase = LifecyclePhase.PROCESS_SOURCES, threadSafe = true)
public class VerifyMojo
        extends AbstractMojo {
    /**
     * Location of the file.
     */
    @Parameter(defaultValue = "${project.basedir}/src", property = "baseDirectory", readonly = true, required = true)
    private File projectBasedir;

    public void execute()
            throws MojoExecutionException, MojoFailureException {

        boolean verify = true;

        Log mavenLog = getLog();

        WhitespaceUtils.detectWhitespace(verify, projectBasedir, mavenLog);

    }

}
