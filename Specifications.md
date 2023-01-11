# qBot

## Definitions

- **Server** / **Guild** are synonymous and refer to Discord servers.
- The **Runner** is the Person executing / running / administrating the bot instance.

## Description

## Handling Secrets

Secrets should be handled some kind of configuration file. The file should be created at startup. If it already exists the existing file and secrets should be loaded. When secrets are missing the Runner should be prompted to enter the missing secrets.

## Bot Role(s)

The bot will create roles for bot administration rights, notifications, etc...

## Reaction Role(s)

Roles should work Guild specific. So every Guild should be able to handle all Role specific actions separate from other Guilds.

### Role(s) Management

#### Role Channel(s)

There should be the possibility to create channels where members can assign roles to themselves. 

When admins create a channel, they will be asked to give it a name and which roles should be added. As well as if they want to categorize the roles. If so, they will be asked to give the categories names and which roles should be under which category. Lastly the admins will be asked to state which roles and/or users have access to the channel.

Admins can modify these channels. If an admin wants to modify a channel they have to specify which channel is to be modified and what he wants to do. They can add/remove/set roles inside and outside of categories. They can add/remove/set categories. They can set the name. They can add/remove/set roles/users which have access to the channel. And they can delete channels.

#### Creating Role(s)

Roles can be created by either creating a new one or by copying another.

When creating a new role, one can specify name, color and ordering (all optional). Options mission will get a default value. The role will be created with no permissions.

When copying a role, name, color and ordering can be changed. Permissions will be copied as well.

#### Modify Role(s)

Names, colors and ordering can be changed when modifying a role.

#### Delete Role(s)

#### De- / Reactivate Role(s)

### Role(s) assignment

#### Give / Take away Role(s) from other User

#### Give / Take away Role(s) from Self
