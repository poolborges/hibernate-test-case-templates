
insert into evmanager_event (ev_id, ev_title, ev_createat) values (1, 'Event has null value at version field', '2017-02-05 10:30:00')

insert into evmanager_event (ev_id, ev_title, ev_createat, ev_version) values (2, 'Event with correct version value', '2017-02-05 14:45:00', 1)