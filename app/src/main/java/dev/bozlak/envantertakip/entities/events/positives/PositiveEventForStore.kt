package dev.bozlak.envantertakip.entities.events.positives

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "positive_events_for_store")
class PositiveEventForStore {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "positive_event_id")
    private var positiveEventId : UInt = 0u

    @ColumnInfo(name = "event_id")
    private var eventId : UInt = 0u

    @ColumnInfo(name = "positive_event_type")
    private var positiveEventType : PositiveEventType? = null

    @ColumnInfo(name = "description")
    private var description : String? = null

}