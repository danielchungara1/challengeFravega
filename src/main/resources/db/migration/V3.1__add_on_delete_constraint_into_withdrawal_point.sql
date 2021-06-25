-- create temp_location column
alter table withdrawal_point
    add column temp_location bigint default null;

-- copy location_id column into temp_location
update withdrawal_point as b
    set temp_location = b.location_id;

-- drop location_id column
alter table withdrawal_point
    drop column location_id;

-- add column location_id
alter table withdrawal_point
    add column location_id bigint default null;

-- add named fk constraint with on deleted cascade
alter table withdrawal_point
    add constraint FK_location_id_branch_office
        foreign key(location_id) references location(id) on delete cascade ;

-- copy temp_location column into new location_id column
update withdrawal_point as b
    set location_id = b.temp_location;

-- drop temp_location column
alter table withdrawal_point
    drop column temp_location;
