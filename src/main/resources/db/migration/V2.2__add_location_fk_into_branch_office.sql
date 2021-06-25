alter table branch_office
    add foreign key (location_id) references location(id);
