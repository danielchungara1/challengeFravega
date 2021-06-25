alter table withdrawal_point
    add foreign key (location_id) references location(id);
