do
$$
    declare
        current_record record;
        last_id bigint;
    begin
        for current_record in select id, latitude, longitude, address
                 from withdrawal_point
            loop

            insert into  location (latitude, longitude, address)
                values (current_record.latitude, current_record.longitude, current_record.address)
                returning id into last_id;

            update withdrawal_point
            set location_id = last_id
            where id = current_record.id;

            end loop;
    end;
$$;