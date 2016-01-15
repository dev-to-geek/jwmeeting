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

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import org.dev2geek.jwmeeting.base.schedule.builder.MeetingScheduleBuilder;
import org.dev2geek.jwmeeting.base.schedule.chunks.MeetingChunk;

import java.io.Serializable;
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
public class MeetingSchedule implements Serializable {


    private static final long serialVersionUID = -3290233650081701074L;
    private final LocalDate date;
    private final LocalTime startTime;
    private final LinkedHashSet<MeetingChunk> meetingChunks;

    public MeetingSchedule(LocalDate date, LocalTime startTime, LinkedHashSet<MeetingChunk> meetingChunks) {
        Preconditions.checkNotNull(date, "date cannot be null");
        Preconditions.checkNotNull(startTime, "startTime cannot be null");
        Preconditions.checkNotNull(meetingChunks, "meetingChunks cannot be null");
        Preconditions.checkArgument(meetingChunks.size() > 0, "meetingChunks cannot be empty");

        this.date = date;
        this.startTime = startTime;
        this.meetingChunks = meetingChunks;
    }

    public MeetingSchedule(LocalDateTime startTime, LinkedHashSet<MeetingChunk> meetingChunks) {
        Preconditions.checkNotNull(startTime, "startTime cannot be null");
        Preconditions.checkNotNull(meetingChunks, "meetingChunks cannot be null");
        Preconditions.checkArgument(meetingChunks.size() > 0, "meetingChunks cannot be empty");
        this.date = startTime.toLocalDate();
        this.startTime = startTime.toLocalTime();
        this.meetingChunks = meetingChunks;
    }

    /**
     * @return the date of this meeting
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @return the time of this meeting
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * @return an immutable copy of the set of chunkes with their inserting order preserved
     */
    public ImmutableSet<MeetingChunk> getMeetingChunks() {
        return ImmutableSet.copyOf(meetingChunks);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("startTime", startTime)
                .add("meetingChunks", meetingChunks)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeetingSchedule that = (MeetingSchedule) o;

        if (!date.equals(that.date)) return false;
        if (!startTime.equals(that.startTime)) return false;
        return meetingChunks.equals(that.meetingChunks);

    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + meetingChunks.hashCode();
        return result;
    }
}

    