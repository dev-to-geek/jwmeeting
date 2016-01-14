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
package org.dev2geek.jwmeeting.base.schedule;

import com.google.common.collect.ImmutableSet;
import org.dev2geek.jwmeeting.base.schedule.builder.MeetingScheduleBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashSet;

/**
 * Class: MeetingSchedule
 * <p>
 * it holds the schedule of the meeting in a SortedSet of MeetingChunk
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 * @see MeetingChunk
 * @see MeetingScheduleBuilder
 */
public class MeetingSchedule {
    private final LocalDate date;
    private final LocalTime startTime;
    private final LinkedHashSet<MeetingChunk> meetingChunks;

    public MeetingSchedule(LocalDate date, LocalTime startTime, LinkedHashSet<MeetingChunk> meetingChunks) {
        this.date = date;
        this.startTime = startTime;
        this.meetingChunks = meetingChunks;
    }

    public MeetingSchedule(LocalDateTime startTime, LinkedHashSet<MeetingChunk> meetingChunks) {
        this.date = startTime.toLocalDate();
        this.startTime = startTime.toLocalTime();
        this.meetingChunks = meetingChunks;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public ImmutableSet<MeetingChunk> getMeetingChunks() {
        return ImmutableSet.copyOf(meetingChunks);
    }
}

    