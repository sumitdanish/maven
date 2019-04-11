package org.apache.maven.artifact.resolver.filter;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

class ModuleIdentifier
{

    static ModuleIdentifier fromString( String s )
    {
        String[] split = StringUtils.split( s, ':' );
        return new ModuleIdentifier( split[ 0 ], split.length > 1 ? split[ 1 ] : "" );
    }

    private final String groupId;
    private final String artifactId;

    ModuleIdentifier( String groupId, String artifactId )
    {
        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public String getArtifactId()
    {
        return artifactId;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        ModuleIdentifier that = (ModuleIdentifier) o;
        return groupId.equals( that.groupId )
                && artifactId.equals( that.artifactId );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( groupId, artifactId );
    }

    @Override
    public String toString()
    {
        return groupId + ( artifactId.isEmpty() ? "" : ":" + artifactId );
    }
}
