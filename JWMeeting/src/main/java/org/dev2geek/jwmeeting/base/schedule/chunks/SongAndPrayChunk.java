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
 * Class: SongAndPrayChunk
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 */
public class SongAndPrayChunk extends SongChunk {

    private static final long serialVersionUID = -7276872307232398241L;
    private final String prayerBrother; //TODO could be a class referenced by a list of brothres? maybe next version

    public SongAndPrayChunk(int number, String theme, String prayerBrother) {
        super(number, theme);
        this.prayerBrother = prayerBrother != null ? prayerBrother : "";
    }

    public String getPrayerBrother() {
        return prayerBrother;
    }

    @Override
    public String toString() {
        return "SongAndPrayChunk{" +
                "number=" + getNumber() +
                ", theme='" + getTheme() + '\'' +
                ", executed='" + isExecuted() + '\'' +
                "prayerBrother='" + prayerBrother + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongAndPrayChunk that = (SongAndPrayChunk) o;

        return prayerBrother.equals(that.prayerBrother);

    }

    @Override
    public int hashCode() {
        return prayerBrother.hashCode();
    }
}

    