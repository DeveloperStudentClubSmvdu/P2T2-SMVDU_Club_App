CREATE TABLE [auth_user] (
  [entry_number] nvarchar(255) PRIMARY KEY,
  [email] integer,
  [name] nvarchar(255),
  [mobile] bigint,
  [password] text
)
GO

CREATE TABLE [clubs] (
  [club_name] nvarchar(255),
  [club_id] integer PRIMARY KEY,
  [img] image,
  [club_cordinator] nvarchar(255),
  [faculty_cordinator] nvarchar(255),
  [club_description] text,
  [club_vision] text
)
GO

CREATE TABLE [announcements] (
  [announcement_id] integer PRIMARY KEY,
  [club_id] integer,
  [event_id] integer,
  [title] nvarchar(255),
  [announcement_description] text,
  [club_name] nvarchar(255),
  [date_time] timestamp
)
GO

CREATE TABLE [events] (
  [event_id] integer PRIMARY KEY,
  [title] nvarchar(255),
  [club_id] integer,
  [event_description] text,
  [event_image] image,
  [date_time] timestamp
)
GO

EXEC sp_addextendedproperty
@name = N'Column_Description',
@value = 'Content of the announcement',
@level0type = N'Schema', @level0name = 'dbo',
@level1type = N'Table',  @level1name = 'announcements',
@level2type = N'Column', @level2name = 'announcement_description';
GO

EXEC sp_addextendedproperty
@name = N'Column_Description',
@value = 'Content of the event',
@level0type = N'Schema', @level0name = 'dbo',
@level1type = N'Table',  @level1name = 'events',
@level2type = N'Column', @level2name = 'event_description';
GO

ALTER TABLE [clubs] ADD FOREIGN KEY ([club_name]) REFERENCES [announcements] ([club_name])
GO

ALTER TABLE [events] ADD FOREIGN KEY ([event_id]) REFERENCES [announcements] ([event_id])
GO

ALTER TABLE [clubs] ADD FOREIGN KEY ([club_id]) REFERENCES [events] ([club_id])
GO
