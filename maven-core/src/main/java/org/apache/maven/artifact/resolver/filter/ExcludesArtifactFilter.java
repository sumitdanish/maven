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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Exclusion;

/**
 * Filter to exclude from a list of artifact patterns.
 *
 * @author <a href="mailto:brett@apache.org">Brett Porter</a>
 */
public class ExcludesArtifactFilter
        extends IncludesArtifactFilter
{

    public static ArtifactFilter forExclusions( List<Exclusion> exclusions )
    {
        List<ModuleIdentifier> modules = new ArrayList<>();

        for ( Exclusion exclusion : exclusions )
        {
            modules.add( new ModuleIdentifier( exclusion.getGroupId(), exclusion.getArtifactId() ) );
        }
        return new ExcludesArtifactFilter( modules );
    }

    public ExcludesArtifactFilter( List<String> patterns )
    {
        super( patterns );
    }

    private ExcludesArtifactFilter( Collection<ModuleIdentifier> modules )
    {
        super( modules );
    }

    public boolean include( Artifact artifact )
    {
        return !super.include( artifact );
    }
}
