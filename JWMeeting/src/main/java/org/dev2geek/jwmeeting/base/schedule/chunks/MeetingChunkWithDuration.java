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

import com.google.common.base.Preconditions;

import java.time.Duration;

/**
 * Class: MeetingChunkWithDuration
 * <p>
 * This represents an assignement with a specific duration. In some cases
 * the assignement could last less.
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 */
public class MeetingChunkWithDuration extends MeetingChunk {

    private static final long serialVersionUID = 7297802275477639085L;
    private final Duration duration;
    private final boolean shouldLastLess;

    /**
     * @param duration       the duration of the assignement
     * @param shouldLastLess true if this assignement could last less
     */
    public MeetingChunkWithDuration(Duration duration, boolean shouldLastLess) {
        Preconditions.checkNotNull(duration, "duration cannot be null");
        this.duration = duration;
        this.shouldLastLess = shouldLastLess;
    }

    /**
     * @param minutes        minutes assigned
     * @param shouldLastLess true if this assignement could last less
     */
    public MeetingChunkWithDuration(int minutes, boolean shouldLastLess) {
        Preconditions.checkArgument(minutes > 0, "minutes might be greater than 0");
        this.duration = Duration.ofMinutes(minutes);
        this.shouldLastLess = shouldLastLess;
    }

    /**
     * @param minutes the minutes of the assignement
     */
    public MeetingChunkWithDuration(int minutes) {
        this(minutes, false);
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isShouldLastLess() {
        return shouldLastLess;
    }

    //TODO implement method for elapsed time


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeetingChunkWithDuration that = (MeetingChunkWithDuration) o;

        if (shouldLastLess != that.shouldLastLess) return false;
        return duration.equals(that.duration);

    }

    @Override
    public int hashCode() {
        int result = duration.hashCode();
        result = 31 * result + (shouldLastLess ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MeetingChunkWithDuration{" +
                "duration=" + duration +
                ", shouldLastLess=" + shouldLastLess +
                ", executed=" + isExecuted() +
                '}';
    }
}

    