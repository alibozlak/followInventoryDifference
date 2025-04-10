package dev.bozlak.envantertakip.entities.events.negatives

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "negative_events_for_store")
class NegativeEventForStore {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "negative_event_id")
    private var negativeEventId : UInt = 0u

    @ColumnInfo(name = "event_id")
    private var eventId : UInt = 0u

    @ColumnInfo(name = "negative_event_type")
    private var negativeEventType : NegativeEventType? = null

    @ColumnInfo(name = "description")
    private var description : String? = null
}