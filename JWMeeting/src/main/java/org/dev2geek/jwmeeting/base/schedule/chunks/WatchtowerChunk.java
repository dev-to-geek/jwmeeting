/*******************************************************************************
 * This file is part of JWMeeting.
 * <p>
 * JWMeeting is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * JWMeeting is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with JWMeeting.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.dev2geek.jwmeeting.base.schedule.chunks;

/**
 * Class: WatchtowerChunk
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 */
public class WatchtowerChunk extends MeetingChunkWithDuration {
    private static final long serialVersionUID = -1695950115575695094L;

    public WatchtowerChunk() {
        super(60);
    }

    public WatchtowerChunk(int minutes) {
        super(minutes);
    }

}

    