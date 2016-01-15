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

import org.dev2geek.jwmeeting.base.schedule.MeetingSchedule;

import java.io.Serializable;

/**
 * Class: MeetingChunk
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 * @see MeetingSchedule
 */
public abstract class MeetingChunk implements Serializable {
    private boolean executed;

    /**
     * @return true if this assignement has concluded
     */
    public boolean isExecuted() {
        return executed;
    }

    /**
     * @param executed indicates if this assignement has concluded
     */
    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    @Override
    public String toString() {
        return "MeetingChunk{" +
                "executed=" + executed +
                '}';
    }

}

    